package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionTileEntityCatalog

class LegacyJavaEditionCatalog: Catalog("legacy-java") {
    override val blockStates = LegacyJavaEditionBlockStateCatalog(this)
    override val items = LegacyJavaEditionItemCatalog(this)
    override val entityTypes = LegacyJavaEditionEntityCatalog(this)
    override val tileEntities = LegacyJavaEditionTileEntityCatalog(this)
}
