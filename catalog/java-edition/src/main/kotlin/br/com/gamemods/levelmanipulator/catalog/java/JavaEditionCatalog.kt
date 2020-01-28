package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog

class JavaEditionCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(JavaEditionBlockState::class)
    override val items =
        ItemCatalog(JavaEditionItem::class)
    override val entityTypes =
        EntityCatalog(JavaEditionEntityType::class)
}
