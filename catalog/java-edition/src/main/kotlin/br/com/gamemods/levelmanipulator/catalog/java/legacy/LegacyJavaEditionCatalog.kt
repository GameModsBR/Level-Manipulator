package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.ItemCatalog

class LegacyJavaEditionCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(LegacyJavaEditionBlockState::class)
    override val items =
        ItemCatalog(LegacyJavaEditionItem::class)
    override val entityTypes =
        EntityCatalog(LegacyJavaEditionEntityType::class)
}
