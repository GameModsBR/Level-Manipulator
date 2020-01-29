package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionTileEntityCatalog

class LegacyBedrockEditionCatalog: Catalog() {
    override val blockStates = LegacyBedrockEditionBlockStateCatalog()
    override val items = LegacyBedrockEditionItemCatalog()
    override val entityTypes = LegacyBedrockEditionEntityCatalog()
    override val tileEntities = LegacyBedrockEditionTileEntityCatalog()
}
