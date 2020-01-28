package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import kotlin.reflect.KClass

@Suppress("ConvertSecondaryConstructorToPrimary")
open class TileEntityCatalog<
        TileEntityIdType: Identification,
        TileEntityClass: TileEntityType<TileEntityIdType>
> {
    constructor(@Suppress("UNUSED_PARAMETER") stateClass: KClass<TileEntityClass>)

    private val registry = mutableMapOf<TileEntityIdType, TileEntityClass>()

    operator fun get(id: TileEntityIdType) = registry[id]

    @JvmName("getReifed")
    inline operator fun <reified Id: TileEntityIdType> get(id: String) = get(Identification<Id>( id ))

    operator fun contains(id: TileEntityIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(tileEntity: TileEntityClass) {
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
