package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionTileEntityCatalog

class LegacyJavaEditionCatalog: Catalog() {
    override val blockStates = LegacyJavaEditionBlockStateCatalog()
    override val items = LegacyJavaEditionItemCatalog()
    override val entityTypes = LegacyJavaEditionEntityCatalog()
    override val tileEntities = LegacyJavaEditionTileEntityCatalog()
}
