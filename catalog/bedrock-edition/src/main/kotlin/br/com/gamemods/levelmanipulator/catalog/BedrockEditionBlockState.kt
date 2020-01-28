package br.com.gamemods.levelmanipulator.catalog

class BedrockEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: SingleLayerCompoundIdentification
): BlockState<NamespacedIdentification, SingleLayerCompoundIdentification>()
