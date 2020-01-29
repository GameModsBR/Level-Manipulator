package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

class ModernBedrockEditionEntityTileEntityType internal constructor(
    override val catalog: ModernBedrockEditionCatalog,
    override val id: StringIdentification
) : TileEntityType<StringIdentification>() {
    override lateinit var universal: UniversalTileEntityType
}
