package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import java.util.*

abstract class TileEntityCatalog<
        TileEntityIdType: Identification,
        TileEntityClass: TileEntityType<TileEntityIdType>
> {
    private val registry: SortedMap<TileEntityIdType, TileEntityClass> = sortedMapOf()

    operator fun get(id: TileEntityIdType): TileEntityClass? = registry[id]
    operator fun get(reference: TileEntityType<TileEntityIdType>) = get(reference.id)

    abstract operator fun get(id: String): TileEntityClass?

    operator fun contains(id: TileEntityIdType) = id in registry
    operator fun contains(reference: TileEntityType<TileEntityIdType>) = contains(reference.id)

    @JvmName("register")
    operator fun plusAssign(tileEntity: TileEntityClass) {
        val current = this[tileEntity]
        require(current == null) {
            "The tile entity type $tileEntity is already registered as $current"
        }
        registry[tileEntity.id] = tileEntity
    }

    @JvmName("unregister")
    operator fun minusAssign(tileEntityType: TileEntityClass) {
        registry -= tileEntityType.id
    }

    override fun toString(): String {
        return "TileEntityCatalog(registry=<${registry.size} tile entity types>)"
    }

}
