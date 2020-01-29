package br.com.gamemods.levelmanipulator.catalog.universal.data

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog

class UniversalTileEntityType internal constructor(
    override val id: NamespacedIdentification
) : TileEntityType<NamespacedIdentification>() {
    override val catalog get() = UniversalCatalog
    override val universal get() = this

    override fun toString(): String {
        return "UniversalTileEntity(id=$id)"
    }
}
