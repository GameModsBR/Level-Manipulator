package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalItem

class JavaEditionItem(
    override val id: NamespacedIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NamespacedIdentification, NumericalIdentification, JavaEditionBlockState>() {
    override lateinit var universal: UniversalItem
}
