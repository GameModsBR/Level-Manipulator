package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import java.util.*

abstract class ItemCatalog<
        CatalogType: Catalog,
        ItemIdType: Identification,
        ItemDataType: Identification,
        BlockStateType: BlockState<*, *>,
        ItemType: Item<ItemIdType, ItemDataType, BlockStateType>
>(
    val catalog: CatalogType
) {
    private val registry: SortedMap<ItemIdType, SortedMap<ItemDataType?, ItemType>> = sortedMapOf()

    operator fun get(id: ItemIdType): List<ItemType> = registry[id]?.values?.toList() ?: emptyList()
    operator fun get(id: ItemIdType, data: ItemDataType?): ItemType? = registry[id]?.get(data)
    operator fun get(reference: Item<ItemIdType, ItemDataType, *>) = get(reference.id, reference.meta)


    abstract operator fun get(id: String): List<ItemType>
    abstract operator fun get(id: String, data: String?): ItemType?

    @Suppress("NOTHING_TO_INLINE")
    @JvmSynthetic
    inline operator fun contains(pair: Pair<ItemIdType, ItemDataType>) = contains(pair.first, pair.second)
    fun contains(id: ItemIdType, data: ItemDataType?) = registry[id]?.containsKey(data) ?: false
    operator fun contains(id: ItemIdType) = id in registry
    operator fun contains(reference: Item<ItemIdType, ItemDataType, *>) = contains(reference.id, reference.meta)

    @JvmName("register")
    operator fun plusAssign(item: ItemType) {
        val current = this[item]
        require(current == null) {
            "The item type $item is already registered as $current"
        }
        registry.getOrPut(item.id, { TreeMap(nullsFirst()) })[item.meta] = item
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
