package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.*

class McRegionBlock(
    override val chunkSection: McRegionChunkSection,
    state: BlockState<NumericalIdentification, NumericalIdentification>, 
    pos: BlockPos
) : Block<NumericalIdentification, NumericalIdentification>(chunkSection, state, pos)
