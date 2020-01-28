package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.BlockPos
import br.com.gamemods.levelmanipulator.base.TileEntity
import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.nbtmanipulator.NbtCompound


class McRegionTileEntity(
    override val chunkSection: McRegionChunkSection,
    override val id: StringIdentification,
    pos: BlockPos,
    saveData: NbtCompound
) : TileEntity<StringIdentification>(chunkSection, pos, saveData)
