package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionItem

object ModernBedrockEditionItemCatalog: ItemCatalog<
        NamespacedIdentification,
        NumericalIdentification,
        ModernBedrockEditionBlockState,
        ModernBedrockEditionItem
>() {
    override val catalog get() = ModernBedrockEditionCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun get(id: String, data: String?) = get(NamespacedIdentification(id), data?.let { NumericalIdentification(it) })
}
