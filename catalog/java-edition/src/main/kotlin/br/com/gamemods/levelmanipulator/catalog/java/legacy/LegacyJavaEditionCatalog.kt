package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.registry.LegacyJavaEditionTileEntityCatalog

object LegacyJavaEditionCatalog: Catalog("legacy-java") {
    override val blockStates get() = LegacyJavaEditionBlockStateCatalog
    override val items get() = LegacyJavaEditionItemCatalog
    override val entityTypes get() = LegacyJavaEditionEntityCatalog
    override val tileEntities get() = LegacyJavaEditionTileEntityCatalog
}
