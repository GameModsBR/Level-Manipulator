package br.com.gamemods.levelmanipulator.catalog.java.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionTileEntityCatalog

class ModernJavaEditionCatalog: Catalog() {
    override val blockStates = ModernJavaEditionBlockStateCatalog()
    override val items = ModernJavaEditionItemCatalog()
    override val entityTypes = ModernJavaEditionEntityCatalog()
    override val tileEntities = ModernJavaEditionTileEntityCatalog()
}
