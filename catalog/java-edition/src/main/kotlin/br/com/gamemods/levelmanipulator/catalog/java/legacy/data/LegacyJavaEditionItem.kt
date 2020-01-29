package br.com.gamemods.levelmanipulator.catalog.java.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem

class LegacyJavaEditionItem internal constructor(
    override val catalog: LegacyJavaEditionCatalog,
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: LegacyJavaEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, LegacyJavaEditionBlockState>() {
    override lateinit var universal: UniversalItem
}
