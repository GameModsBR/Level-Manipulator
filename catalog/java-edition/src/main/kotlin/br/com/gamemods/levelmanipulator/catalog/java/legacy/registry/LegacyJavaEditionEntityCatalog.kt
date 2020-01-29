package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionEntityType

class LegacyJavaEditionEntityCatalog internal constructor(): EntityCatalog<StringIdentification, LegacyJavaEditionEntityType>() {
    override fun get(id: String) = get(StringIdentification(id))
}
