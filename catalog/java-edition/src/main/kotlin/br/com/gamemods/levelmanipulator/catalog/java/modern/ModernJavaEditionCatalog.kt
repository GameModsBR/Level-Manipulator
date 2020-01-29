package br.com.gamemods.levelmanipulator.catalog.java.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionTileEntityCatalog

object ModernJavaEditionCatalog: Catalog("modern-java") {
    override val blockStates get() = ModernJavaEditionBlockStateCatalog
    override val items get() = ModernJavaEditionItemCatalog
    override val entityTypes get() = ModernJavaEditionEntityCatalog
    override val tileEntities get() = ModernJavaEditionTileEntityCatalog
}
