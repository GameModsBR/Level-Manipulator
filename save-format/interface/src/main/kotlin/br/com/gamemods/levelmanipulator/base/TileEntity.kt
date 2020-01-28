package br.com.gamemods.levelmanipulator.base

import br.com.gamemods.levelmanipulator.catalog.api.Identification
import br.com.gamemods.nbtmanipulator.NbtCompound

abstract class TileEntity<IdType: Identification>(open val chunkSection: ChunkSection, val pos: BlockPos, val saveData: NbtCompound)
        : Vectors3i by pos, InWorld by chunkSection {
    abstract val id: IdType
    val chunk get() = chunkSection.chunk
}
