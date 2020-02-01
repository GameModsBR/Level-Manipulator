package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionBlockState

class LegacyJavaEditionBlockStateCatalog private constructor(catalog: LegacyJavaEditionCatalog): BlockStateCatalog<
        LegacyJavaEditionCatalog,
        NumericalIdentification, 
        NumericalIdentification,
        LegacyJavaEditionBlockState
>(catalog) {
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun getIfRegistered(id: String, data: String) = getIfRegistered(NumericalIdentification(id), NumericalIdentification(data))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyJavaEditionCatalog) = LegacyJavaEditionBlockStateCatalog(catalog)
    }
}
