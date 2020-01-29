package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry.LegacyBedrockEditionTileEntityCatalog

object LegacyBedrockEditionCatalog: Catalog("legacy-bedrock") {
    override val blockStates get() = LegacyBedrockEditionBlockStateCatalog
    override val items get() = LegacyBedrockEditionItemCatalog
    override val entityTypes get() = LegacyBedrockEditionEntityCatalog
    override val tileEntities get() = LegacyBedrockEditionTileEntityCatalog
}
