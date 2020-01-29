package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionEntityType

class ModernJavaEditionEntityCatalog internal constructor(
    override val catalog: ModernJavaEditionCatalog
): EntityCatalog<NamespacedIdentification, ModernJavaEditionEntityType>() {
    override fun get(id: String) = get(NamespacedIdentification(id))
}
