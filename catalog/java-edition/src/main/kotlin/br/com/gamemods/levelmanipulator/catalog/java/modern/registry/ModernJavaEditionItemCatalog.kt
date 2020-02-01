package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionItem

class ModernJavaEditionItemCatalog private constructor(catalog: ModernJavaEditionCatalog): ItemCatalog<
        ModernJavaEditionCatalog,
        NamespacedIdentification,
        NumericalIdentification, 
        ModernJavaEditionBlockState,
        ModernJavaEditionItem
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun get(id: String, data: String?) = get(NamespacedIdentification(id), data?.let { NumericalIdentification(it) })

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: ModernJavaEditionCatalog) = ModernJavaEditionItemCatalog(catalog)
    }
}
