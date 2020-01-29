package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionTileEntityType

class LegacyBedrockEditionTileEntityCatalog internal constructor(
    override val catalog: LegacyBedrockEditionCatalog
): TileEntityCatalog<StringIdentification, LegacyBedrockEditionTileEntityType>(){
    override fun get(id: String) = get(StringIdentification(id))
}
