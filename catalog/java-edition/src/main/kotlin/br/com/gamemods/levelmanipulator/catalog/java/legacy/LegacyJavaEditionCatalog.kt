package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog

class LegacyJavaEditionCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(
            LegacyJavaEditionBlockState::class
        )
    override val items =
        ItemCatalog(LegacyJavaEditionItem::class)
    override val entityTypes =
        EntityCatalog(
            LegacyJavaEditionEntityType::class
        )
}
