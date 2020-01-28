package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.Block
import br.com.gamemods.levelmanipulator.base.BlockPos
import br.com.gamemods.levelmanipulator.catalog.api.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.NumericalIdentification

class McRegionBlock(
    override val chunkSection: McRegionChunkSection,
    state: BlockState<NumericalIdentification, NumericalIdentification>,
    pos: BlockPos
) : Block<NumericalIdentification, NumericalIdentification>(chunkSection, state, pos)
