package br.com.gamemods.levelmanipulator.catalog.bedrock.modern

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.UniversalBlockMapper
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry.ModernBedrockEditionTileEntityCatalog

object ModernBedrockEditionCatalog: Catalog("modern-bedrock") {
    override val blockStates = ModernBedrockEditionBlockStateCatalog(this)
    override val items = ModernBedrockEditionItemCatalog(this)
    override val entityTypes = ModernBedrockEditionEntityCatalog(this)
    override val tileEntities = ModernBedrockEditionTileEntityCatalog(this)
    
    init {
        val mapper = UniversalBlockMapper()
        loadBlockStatesIni("/levelmanipulator/catalog/bedrock/modern/block-states.ini") { blockId, blockData ->
            val blockState = ModernBedrockEditionBlockState(blockId, blockData)
            blockState.universal = mapper[blockState]
            blockStates += blockState
        }
    }
}
