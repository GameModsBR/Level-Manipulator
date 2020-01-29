package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaTileEntityType

class LegacyJavaEditionTileEntityCatalog internal constructor(): TileEntityCatalog<StringIdentification, LegacyJavaTileEntityType>() {
    override fun get(id: String) = get(StringIdentification(id))
}
