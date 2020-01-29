package br.com.gamemods.levelmanipulator.catalog.java.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class ModernJavaEditionEntityType internal constructor(
    override val catalog: LegacyJavaEditionCatalog,
    override val id: NamespacedIdentification
): EntityType<NamespacedIdentification>() {
    override lateinit var universal: UniversalEntityType
}
