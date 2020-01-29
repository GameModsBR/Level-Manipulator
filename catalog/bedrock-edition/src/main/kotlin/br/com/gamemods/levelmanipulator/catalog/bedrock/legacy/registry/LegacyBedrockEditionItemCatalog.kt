package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionItem

class LegacyBedrockEditionItemCatalog internal constructor(): ItemCatalog<NumericalIdentification, NumericalIdentification, LegacyBedrockEditionBlockState, LegacyBedrockEditionItem>() {
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun get(id: String, data: String?) = get(NumericalIdentification(id), data?.let { NumericalIdentification(it) })
}
