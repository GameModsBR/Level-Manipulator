package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionEntityType

class LegacyJavaEditionEntityCatalog private constructor(catalog: LegacyJavaEditionCatalog): EntityCatalog<
        LegacyJavaEditionCatalog,
        StringIdentification,
        LegacyJavaEditionEntityType
>(LegacyJavaEditionCatalog) {
    override fun get(id: String) = get(StringIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyJavaEditionCatalog) = LegacyJavaEditionEntityCatalog(catalog)
    }
}
