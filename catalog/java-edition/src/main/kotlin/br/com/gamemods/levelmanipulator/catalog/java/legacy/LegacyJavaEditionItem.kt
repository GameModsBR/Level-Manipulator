package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.java.JavaEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalItem

class LegacyJavaEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, JavaEditionBlockState>() {
    override lateinit var universal: UniversalItem
}
