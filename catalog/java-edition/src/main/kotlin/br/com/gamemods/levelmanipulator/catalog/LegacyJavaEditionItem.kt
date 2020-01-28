package br.com.gamemods.levelmanipulator.catalog

class LegacyJavaEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: JavaEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, JavaEditionBlockState>()
