package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntity

class UniversalTileEntity(override val id: NamespacedIdentification) : TileEntity<NamespacedIdentification>() {
    override val universal get() = this

    override fun toString(): String {
        return "UniversalTileEntity(id=$id)"
    }
}
