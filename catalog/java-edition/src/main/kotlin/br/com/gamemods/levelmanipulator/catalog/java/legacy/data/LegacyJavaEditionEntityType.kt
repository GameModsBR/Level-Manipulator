package br.com.gamemods.levelmanipulator.catalog.java.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class LegacyJavaEditionEntityType internal constructor(
    override val id: StringIdentification
): EntityType<StringIdentification>() {
    override val catalog get() = LegacyJavaEditionCatalog
    override lateinit var universal: UniversalEntityType
}
