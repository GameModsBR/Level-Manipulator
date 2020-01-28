package br.com.gamemods.levelmanipulator.catalog.api

import kotlin.reflect.KClass

@Suppress("ConvertSecondaryConstructorToPrimary")
open class ItemCatalog<
        ItemIdType: Identification,
        ItemDataType: Identification,
        BlockStateType: BlockState<*, *>,
        ItemType: Item<ItemIdType, ItemDataType, BlockStateType>
> {
    constructor(@Suppress("UNUSED_PARAMETER") stateClass: KClass<ItemType>)

    private val registry = mutableMapOf<ItemIdType, MutableMap<ItemDataType?, ItemType>>()

    operator fun get(id: ItemIdType) = registry[id]?.values?.toList() ?: emptyList()
    operator fun get(id: ItemIdType, data: ItemDataType?) = registry[id]?.get(data)


    @JvmName("getReifed")
    inline operator fun <reified Id: ItemIdType> get(id: String) = get(
        Identification<Id>(
            id
        )
    )
    @JvmName("getReifed")
    inline operator fun <reified Id: ItemIdType, reified Data: ItemDataType> get(id: String, data: String?)
            = get(Identification<Id>(id), data?.let {
        Identification<Data>(
            it
        )
    })

    @Suppress("NOTHING_TO_INLINE")
    @JvmSynthetic
    inline operator fun contains(pair: Pair<ItemIdType, ItemDataType>) = contains(pair.first, pair.second)
    fun contains(id: ItemIdType, data: ItemDataType) = registry[id]?.containsKey(data) ?: false
    operator fun contains(id: ItemIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(item: ItemType) {
        registry.getOrPut(item.id, ::mutableMapOf)[item.meta] = item
    }

    @JvmName("unregister")
    operator fun minusAssign(item: ItemType) {
        val states = registry[item.id] ?: return
        states -= item.meta
        if (states.isEmpty()) {
            registry -= item.id
        }
    }

    override fun toString(): String {
        return "ItemCatalog(registry=<${registry.size} items>)"
    }

}
