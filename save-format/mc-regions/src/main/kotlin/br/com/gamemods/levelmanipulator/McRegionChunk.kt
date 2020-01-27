package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.Chunk
import br.com.gamemods.levelmanipulator.base.ChunkPos

class McRegionChunk(override val region: McRegionRegion, pos: ChunkPos): Chunk(region, pos) {
}