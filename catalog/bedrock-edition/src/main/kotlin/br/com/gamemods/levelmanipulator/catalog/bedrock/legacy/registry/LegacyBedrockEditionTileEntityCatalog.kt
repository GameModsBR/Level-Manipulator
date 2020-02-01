package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionTileEntityType

class LegacyBedrockEditionTileEntityCatalog private constructor(catalog: LegacyBedrockEditionCatalog): TileEntityCatalog<
        LegacyBedrockEditionCatalog,
        StringIdentification, 
        LegacyBedrockEditionTileEntityType
>(catalog){
    override fun get(id: String) = get(StringIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyBedrockEditionCatalog) = LegacyBedrockEditionTileEntityCatalog(catalog)
    }
}
