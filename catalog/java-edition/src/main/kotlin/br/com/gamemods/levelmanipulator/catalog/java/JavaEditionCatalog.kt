package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.ItemCatalog

class JavaEditionCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(JavaEditionBlockState::class)
    override val items =
        ItemCatalog(JavaEditionItem::class)
    override val entityTypes =
        EntityCatalog(JavaEditionEntityType::class)
}
