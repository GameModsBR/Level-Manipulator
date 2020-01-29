package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class LegacyBedrockEditionEntityType internal constructor(
    override val id: StringIdentification
): EntityType<StringIdentification>() {
    override val catalog get() = LegacyBedrockEditionCatalog
    override lateinit var universal: UniversalEntityType
}
