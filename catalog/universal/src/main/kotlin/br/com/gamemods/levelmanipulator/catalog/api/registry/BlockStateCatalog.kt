package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import java.util.*
import kotlin.NoSuchElementException

abstract class BlockStateCatalog<
        BlockIdType: Identification,
        BlockDataType: Identification,
        StateType: BlockState<BlockIdType, BlockDataType>
> {
    abstract val catalog: Catalog
    private val registry: SortedMap<BlockIdType, SortedMap<BlockDataType, StateType>> = sortedMapOf()

    operator fun get(id: BlockIdType): List<StateType> = registry[id]?.values?.toList() ?: emptyList()
    operator fun get(id: BlockIdType, data: BlockDataType) = getIfRegistered(id, data) ?: throw NoSuchElementException("$id;$data")
    fun getIfRegistered(id: BlockIdType, data: BlockDataType): StateType? = registry[id]?.get(data)
    fun getIfRegistered(reference: BlockState<BlockIdType, BlockDataType>) = getIfRegistered(reference.id, reference.state)


    abstract operator fun get(id: String): List<StateType>
    abstract fun getIfRegistered(id: String, data: String): StateType?
    operator fun get(id: String, data: String) = getIfRegistered(id, data) ?: NoSuchElementException("$id;$data")

    @Suppress("NOTHING_TO_INLINE")
    @JvmSynthetic
    inline operator fun contains(pair: Pair<BlockIdType, BlockDataType>) = contains(pair.first, pair.second)
    operator fun contains(reference: BlockState<BlockIdType, BlockDataType>) = contains(reference.id, reference.state)
    fun contains(id: BlockIdType, data: BlockDataType) = registry[id]?.containsKey(data) ?: false
    operator fun contains(id: BlockIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(block: StateType) {
        val current = this.getIfRegistered(block)
        require(current == null) {
            "The block state $block is already registered as $current"
        }
        registry.getOrPut(block.id, { sortedMapOf() })[block.state] = block
    }

    @JvmName("unregister")
    operator fun minusAssign(block: StateType) {
        val states = registry[block.id] ?: return
        states -= block.state
        if (states.isEmpty()) {
            registry -= block.id
        }
    }

    override fun toString(): String {
        return "BlockStateCatalog(registry=<${registry.size} states>)"
    }

}
