package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaTileEntityType

object LegacyJavaEditionTileEntityCatalog: TileEntityCatalog<
        StringIdentification,
        LegacyJavaTileEntityType
>() {
    override val catalog get() = LegacyJavaEditionCatalog
    override fun get(id: String) = get(StringIdentification(id))
}
