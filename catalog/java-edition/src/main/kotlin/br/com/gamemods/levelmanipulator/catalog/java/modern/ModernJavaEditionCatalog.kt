package br.com.gamemods.levelmanipulator.catalog.java.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.registry.ModernJavaEditionTileEntityCatalog

class ModernJavaEditionCatalog: Catalog("modern-java") {
    override val blockStates = ModernJavaEditionBlockStateCatalog(this)
    override val items = ModernJavaEditionItemCatalog(this)
    override val entityTypes = ModernJavaEditionEntityCatalog(this)
    override val tileEntities = ModernJavaEditionTileEntityCatalog(this)
}
