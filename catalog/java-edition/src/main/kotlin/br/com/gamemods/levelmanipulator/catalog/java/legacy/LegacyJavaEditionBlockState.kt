package br.com.gamemods.levelmanipulator.catalog.java.legacy

import br.com.gamemods.levelmanipulator.catalog.api.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.NumericalIdentification

class LegacyJavaEditionBlockState(
    override val id: NumericalIdentification,
    override val state: NumericalIdentification
): BlockState<NumericalIdentification, NumericalIdentification>()
