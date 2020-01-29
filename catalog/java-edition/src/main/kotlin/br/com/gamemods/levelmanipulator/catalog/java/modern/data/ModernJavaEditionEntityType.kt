package br.com.gamemods.levelmanipulator.catalog.java.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class ModernJavaEditionEntityType(override val id: NamespacedIdentification): EntityType<NamespacedIdentification>() {
    override lateinit var universal: UniversalEntityType
}
