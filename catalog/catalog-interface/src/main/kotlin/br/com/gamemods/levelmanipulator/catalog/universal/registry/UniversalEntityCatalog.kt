package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

object UniversalEntityCatalog: EntityCatalog<NamespacedIdentification, UniversalEntityType>() {
    override fun get(id: String) = get(NamespacedIdentification(id))
}
