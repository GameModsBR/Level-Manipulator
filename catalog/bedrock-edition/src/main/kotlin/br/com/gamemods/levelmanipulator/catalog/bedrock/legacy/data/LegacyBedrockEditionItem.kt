package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem

class LegacyBedrockEditionItem internal constructor(
    override val id: NumericalIdentification,
    override val meta: NumericalIdentification?,
    override val block: LegacyBedrockEditionBlockState?
): Item<NumericalIdentification, NumericalIdentification, LegacyBedrockEditionBlockState>() {
    override val catalog get() = LegacyBedrockEditionCatalog
    override lateinit var universal: UniversalItem
}
