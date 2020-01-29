package br.com.gamemods.levelmanipulator.catalog.api.data

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

abstract class TileEntityType<IdType: Identification> {
    abstract val catalog: Catalog
    abstract val id: IdType
    abstract val universal: UniversalTileEntityType

    fun component1() = id
    fun component2() = universal

    override fun toString(): String {
        return "TileEntity(id=$id, universal=$universal)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TileEntityType<*>

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}
