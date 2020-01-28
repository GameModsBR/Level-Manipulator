package br.com.gamemods.levelmanipulator.catalog.bedrock

import br.com.gamemods.levelmanipulator.catalog.api.Item
import br.com.gamemods.levelmanipulator.catalog.api.NumericalIdentification

class BedrockEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: BedrockEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, BedrockEditionBlockState>()
