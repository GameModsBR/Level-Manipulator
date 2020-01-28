package br.com.gamemods.levelmanipulator.catalog.universal.data

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType

class UniversalTileEntityType(override val id: NamespacedIdentification) : TileEntityType<NamespacedIdentification>() {
    override val universal get() = this

    override fun toString(): String {
        return "UniversalTileEntity(id=$id)"
    }
}
