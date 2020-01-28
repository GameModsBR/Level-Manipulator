package br.com.gamemods.levelmanipulator.base

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification

open class Block<IdType: Identification, DataType: Identification>(
    open val chunkSection: ChunkSection,
    open val state: BlockState<IdType, DataType>,
    val pos: BlockPos
) : Vectors3i by pos, InWorld by chunkSection {
    val layer get() = pos.layer
}
