package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionEntityTileEntityType

class ModernBedrockEditionTileEntityCatalog: TileEntityCatalog<StringIdentification, ModernBedrockEditionEntityTileEntityType>() {
    override fun get(id: String) = get(StringIdentification(id))
}
