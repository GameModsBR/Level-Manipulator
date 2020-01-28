package br.com.gamemods.levelmanipulator.catalog.bedrock

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog

class BedrockEditionCatalog: Catalog() {
    override val blockStates =
        BlockStateCatalog(
            BedrockEditionBlockState::class
        )
    override val items =
        ItemCatalog(BedrockEditionItem::class)
    override val entityTypes =
        EntityCatalog(BedrockEditionEntityType::class)
}
