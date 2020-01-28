package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalEntityType

class JavaEditionEntityType(override val id: NamespacedIdentification): EntityType<NamespacedIdentification>() {
    override lateinit var universal: UniversalEntityType
}
