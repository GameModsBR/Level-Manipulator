package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.Item
import br.com.gamemods.levelmanipulator.catalog.api.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.java.JavaEditionBlockState

class LegacyJavaEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, JavaEditionBlockState>()
