package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionBlockState

class LegacyBedrockEditionBlockStateCatalog private constructor(catalog: LegacyBedrockEditionCatalog): BlockStateCatalog<
        LegacyBedrockEditionCatalog,
        NumericalIdentification, 
        NumericalIdentification,
        LegacyBedrockEditionBlockState
>(catalog){
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun getIfRegistered(id: String, data: String) = getIfRegistered(NumericalIdentification(id), NumericalIdentification(data))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyBedrockEditionCatalog) = LegacyBedrockEditionBlockStateCatalog(catalog)
    }
}
