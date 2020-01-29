package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaEditionBlockState

object LegacyJavaEditionBlockStateCatalog: BlockStateCatalog<
        NumericalIdentification, 
        NumericalIdentification,
        LegacyJavaEditionBlockState
>() {
    override val catalog get() = LegacyJavaEditionCatalog
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun get(id: String, data: String) = get(NumericalIdentification(id), NumericalIdentification(data))
}
