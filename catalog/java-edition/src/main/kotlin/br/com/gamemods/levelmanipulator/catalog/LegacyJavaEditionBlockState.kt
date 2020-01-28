package br.com.gamemods.levelmanipulator.catalog

class LegacyJavaEditionBlockState(
    override val id: NumericalIdentification,
    override val state: NumericalIdentification
): BlockState<NumericalIdentification, NumericalIdentification>()
