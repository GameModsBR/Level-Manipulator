package br.com.gamemods.levelmanipulator.catalog

class BedrockEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: BedrockEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, BedrockEditionBlockState>()
