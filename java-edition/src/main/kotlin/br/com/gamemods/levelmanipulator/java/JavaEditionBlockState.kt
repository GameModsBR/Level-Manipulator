package br.com.gamemods.levelmanipulator.java

import br.com.gamemods.levelmanipulator.base.BlockState
import br.com.gamemods.levelmanipulator.base.CompoundIdentification
import br.com.gamemods.levelmanipulator.base.NamespacedIdentification

class JavaEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: CompoundIdentification
): BlockState<NamespacedIdentification, CompoundIdentification>()
