package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalEntityType

class LegacyJavaEditionEntityType(override val id: StringIdentification): EntityType<StringIdentification>() {
    override lateinit var universal: UniversalEntityType
}
