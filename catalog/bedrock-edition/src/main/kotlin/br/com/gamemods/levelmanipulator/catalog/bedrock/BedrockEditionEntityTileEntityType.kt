package br.com.gamemods.levelmanipulator.catalog.bedrock

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

class BedrockEditionEntityTileEntityType(override val id: StringIdentification) : TileEntityType<StringIdentification>() {
    override lateinit var universal: UniversalTileEntityType
}
