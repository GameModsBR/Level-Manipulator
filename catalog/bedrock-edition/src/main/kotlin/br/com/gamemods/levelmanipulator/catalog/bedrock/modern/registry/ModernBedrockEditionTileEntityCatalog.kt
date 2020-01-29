package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionEntityTileEntityType

object ModernBedrockEditionTileEntityCatalog: TileEntityCatalog<
        StringIdentification,
        ModernBedrockEditionEntityTileEntityType
>() {
    override val catalog get() = ModernBedrockEditionCatalog
    override fun get(id: String) = get(StringIdentification(id))
}
