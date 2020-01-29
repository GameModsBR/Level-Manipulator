package br.com.gamemods.levelmanipulator.catalog.bedrock.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionTileEntityCatalog

class ModernBedrockEditionCatalog: Catalog() {
    override val blockStates = ModernBedrockEditionBlockStateCatalog()
    override val items = ModernBedrockEditionItemCatalog()
    override val entityTypes = ModernBedrockEditionEntityCatalog()
    override val tileEntities = ModernBedrockEditionTileEntityCatalog()
}
