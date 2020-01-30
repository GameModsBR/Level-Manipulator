package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.SingleLayerCompoundIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState

object ModernBedrockEditionBlockStateCatalog: BlockStateCatalog<
        NamespacedIdentification,
        SingleLayerCompoundIdentification,
        ModernBedrockEditionBlockState
>(){
    override val catalog get() = ModernBedrockEditionCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun getIfRegistered(id: String, data: String) = getIfRegistered(NamespacedIdentification(id), SingleLayerCompoundIdentification(data))
}
