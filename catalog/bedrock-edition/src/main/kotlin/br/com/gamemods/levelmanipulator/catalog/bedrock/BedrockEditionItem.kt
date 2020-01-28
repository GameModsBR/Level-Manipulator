package br.com.gamemods.levelmanipulator.catalog.bedrock

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalItem

class BedrockEditionItem(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: BedrockEditionBlockState?
) : Item<NumericalIdentification, NumericalIdentification, BedrockEditionBlockState>() {
    override lateinit var universal: UniversalItem
}
