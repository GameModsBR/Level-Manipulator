package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.Item
import br.com.gamemods.levelmanipulator.catalog.api.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.NumericalIdentification

class JavaEditionItem(
    override val id: NamespacedIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NamespacedIdentification, NumericalIdentification, JavaEditionBlockState>()
