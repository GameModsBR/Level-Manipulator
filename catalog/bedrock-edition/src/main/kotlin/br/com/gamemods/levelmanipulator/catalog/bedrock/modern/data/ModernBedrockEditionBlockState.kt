package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.SingleLayerCompoundIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

class ModernBedrockEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: SingleLayerCompoundIdentification
): BlockState<NamespacedIdentification, SingleLayerCompoundIdentification>() {
    override lateinit var universal: UniversalBlockState
}