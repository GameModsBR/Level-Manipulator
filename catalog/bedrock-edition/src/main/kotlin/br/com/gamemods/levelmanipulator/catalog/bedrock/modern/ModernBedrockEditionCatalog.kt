package br.com.gamemods.levelmanipulator.catalog.bedrock.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionTileEntityCatalog

class ModernBedrockEditionCatalog: Catalog("modern-bedrock") {
    override val blockStates = ModernBedrockEditionBlockStateCatalog(this)
    override val items = ModernBedrockEditionItemCatalog(this)
    override val entityTypes = ModernBedrockEditionEntityCatalog(this)
    override val tileEntities = ModernBedrockEditionTileEntityCatalog(this)
}
