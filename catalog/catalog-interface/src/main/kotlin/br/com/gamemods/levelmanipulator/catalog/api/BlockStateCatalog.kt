package br.com.gamemods.levelmanipulator.catalog.api

import kotlin.reflect.KClass

@Suppress("ConvertSecondaryConstructorToPrimary")
open class BlockStateCatalog<BlockIdType: Identification, BlockDataType: Identification, StateType: BlockState<BlockIdType, BlockDataType>> {
    constructor(@Suppress("UNUSED_PARAMETER") stateClass: KClass<StateType>)

    private val registry = mutableMapOf<BlockIdType, MutableMap<BlockDataType, StateType>>()

    operator fun get(id: BlockIdType) = registry[id]?.values?.toList() ?: emptyList()
    operator fun get(id: BlockIdType, data: BlockDataType) = registry[id]?.get(data)


    @JvmName("getReifed")
    inline operator fun <reified Id: BlockIdType> get(id: String) = get(
        Identification<Id>(
            id
        )
    )
    @JvmName("getReifed")
    inline operator fun <reified Id: BlockIdType, reified Data: BlockDataType> get(id: String, data: String)
            = get(
        Identification<Id>(id),
        Identification<Data>(data)
    )

    @Suppress("NOTHING_TO_INLINE")
    @JvmSynthetic
    inline operator fun contains(pair: Pair<BlockIdType, BlockDataType>) = contains(pair.first, pair.second)
    fun contains(id: BlockIdType, data: BlockDataType) = registry[id]?.containsKey(data) ?: false
    operator fun contains(id: BlockIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(block: StateType) {
        registry.getOrPut(block.id, ::mutableMapOf)[block.state] = block
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
