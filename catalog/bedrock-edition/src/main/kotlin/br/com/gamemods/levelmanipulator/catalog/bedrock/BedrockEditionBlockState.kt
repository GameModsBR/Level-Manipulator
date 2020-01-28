package br.com.gamemods.levelmanipulator.catalog.bedrock

import br.com.gamemods.levelmanipulator.catalog.api.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.SingleLayerCompoundIdentification

class BedrockEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: SingleLayerCompoundIdentification
): BlockState<NamespacedIdentification, SingleLayerCompoundIdentification>()
