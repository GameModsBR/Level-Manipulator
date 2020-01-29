package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionBlockState

class LegacyBedrockEditionBlockStateCatalog internal constructor(): BlockStateCatalog<NumericalIdentification, NumericalIdentification, LegacyBedrockEditionBlockState>(){
    override fun get(id: String) = get(NumericalIdentification(id))
    override fun get(id: String, data: String) = get(NumericalIdentification(id), NumericalIdentification(data))
}
