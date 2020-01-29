package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

class LegacyBedrockEditionTileEntityType internal constructor(override val id: StringIdentification): TileEntityType<StringIdentification>(){
    override lateinit var universal: UniversalTileEntityType
}
