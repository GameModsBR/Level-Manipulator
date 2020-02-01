package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionEntityTileEntityType

class ModernBedrockEditionTileEntityCatalog private constructor(catalog: ModernBedrockEditionCatalog): TileEntityCatalog<
        ModernBedrockEditionCatalog,
        StringIdentification,
        ModernBedrockEditionEntityTileEntityType
>(catalog) {
    override fun get(id: String) = get(StringIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: ModernBedrockEditionCatalog) = ModernBedrockEditionTileEntityCatalog(catalog)
    }
}
