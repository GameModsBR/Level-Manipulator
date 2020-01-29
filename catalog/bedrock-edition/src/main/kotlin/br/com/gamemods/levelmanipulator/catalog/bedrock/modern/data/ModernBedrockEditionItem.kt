package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem

class ModernBedrockEditionItem(
    override val id: NamespacedIdentification,
    override val meta: NumericalIdentification?,
    override val block: ModernBedrockEditionBlockState?
) : Item<NamespacedIdentification, NumericalIdentification, ModernBedrockEditionBlockState>() {
    override lateinit var universal: UniversalItem
}
