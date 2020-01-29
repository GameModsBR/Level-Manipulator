package br.com.gamemods.levelmanipulator.catalog.bedrock.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionTileEntityCatalog

object ModernBedrockEditionCatalog: Catalog("modern-bedrock") {
    override val blockStates get() = ModernBedrockEditionBlockStateCatalog
    override val items get() = ModernBedrockEditionItemCatalog
    override val entityTypes get() = ModernBedrockEditionEntityCatalog
    override val tileEntities get() = ModernBedrockEditionTileEntityCatalog
    
    init {
        loadBlockStatesIni("/levelmanipulator/catalog/bedrock/modern/block-states.ini") { blockId, blockData ->
            blockStates += ModernBedrockEditionBlockState(blockId, blockData)
        }
    }
}
