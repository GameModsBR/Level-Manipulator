package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

class LegacyBedrockEditionBlockState internal constructor(
    override val id: NumericalIdentification,
    override val state: NumericalIdentification
): BlockState<NumericalIdentification, NumericalIdentification>(){
    override val catalog get() = LegacyBedrockEditionCatalog
    override lateinit var universal: UniversalBlockState
}
