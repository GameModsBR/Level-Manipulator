package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionItem

class LegacyJavaEditionItemCatalog private constructor(catalog: LegacyJavaEditionCatalog): ItemCatalog<
        LegacyJavaEditionCatalog,
        NumericalIdentification,
        NumericalIdentification,
        LegacyJavaEditionBlockState,
        LegacyJavaEditionItem
>(LegacyJavaEditionCatalog) {
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun get(id: String, data: String?) = get(NumericalIdentification(id), data?.let { NumericalIdentification(it) })

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyJavaEditionCatalog) = LegacyJavaEditionItemCatalog(catalog)
    }
}
