package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionEntityType

class ModernJavaEditionEntityCatalog private constructor(catalog: ModernJavaEditionCatalog): EntityCatalog<
        ModernJavaEditionCatalog,
        NamespacedIdentification,
        ModernJavaEditionEntityType
>(ModernJavaEditionCatalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: ModernJavaEditionCatalog) = ModernJavaEditionEntityCatalog(catalog)
    }
}
