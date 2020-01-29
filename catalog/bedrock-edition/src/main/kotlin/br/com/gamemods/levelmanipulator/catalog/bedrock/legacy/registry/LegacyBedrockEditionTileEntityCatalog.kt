package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionTileEntityType

object LegacyBedrockEditionTileEntityCatalog: TileEntityCatalog<
        StringIdentification, 
        LegacyBedrockEditionTileEntityType
>(){
    override val catalog get() = LegacyBedrockEditionCatalog
    override fun get(id: String) = get(StringIdentification(id))
}
