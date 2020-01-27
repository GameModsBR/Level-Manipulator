package br.com.gamemods.levelmanipulator.catalog

class JavaEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: CompoundIdentification
): BlockState<NamespacedIdentification, CompoundIdentification>()
