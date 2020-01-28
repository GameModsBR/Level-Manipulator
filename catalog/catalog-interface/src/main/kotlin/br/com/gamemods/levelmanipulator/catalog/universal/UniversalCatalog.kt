package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog

object UniversalCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(UniversalBlockState::class)
    override val items =
        ItemCatalog(UniversalItem::class)
    override val entityTypes =
        EntityCatalog(UniversalEntityType::class)
}
