package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class UniversalEntityCatalog private constructor(catalog: UniversalCatalog): EntityCatalog<
        UniversalCatalog,
        NamespacedIdentification,
        UniversalEntityType
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: UniversalCatalog) = UniversalEntityCatalog(catalog)
    }
}
