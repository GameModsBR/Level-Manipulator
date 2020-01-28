package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import java.util.*

abstract class BlockStateCatalog<BlockIdType: Identification, BlockDataType: Identification, StateType: BlockState<BlockIdType, BlockDataType>> {
    private val registry: SortedMap<BlockIdType, SortedMap<BlockDataType, StateType>> = sortedMapOf()

    operator fun get(id: BlockIdType): List<StateType> = registry[id]?.values?.toList() ?: emptyList()
    operator fun get(id: BlockIdType, data: BlockDataType): StateType? = registry[id]?.get(data)
    operator fun get(reference: BlockState<BlockIdType, BlockDataType>) = get(reference.id, reference.state)


    abstract operator fun get(id: String): List<StateType>
    abstract operator fun get(id: String, data: String): StateType?
    
    @Suppress("NOTHING_TO_INLINE")
    @JvmSynthetic
    inline operator fun contains(pair: Pair<BlockIdType, BlockDataType>) = contains(pair.first, pair.second)
    operator fun contains(reference: BlockState<BlockIdType, BlockDataType>) = contains(reference.id, reference.state)
    fun contains(id: BlockIdType, data: BlockDataType) = registry[id]?.containsKey(data) ?: false
    operator fun contains(id: BlockIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(block: StateType) {
        val current = this[block]
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
