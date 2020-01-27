package br.com.gamemods.levelmanipulator.base

abstract class ChunkSection private constructor(open val chunk: Chunk, val pos: ChunkSectionPos)
        : Vectors3i by pos, InWorld by chunk {
    constructor(chunk: Chunk, y: Int): this(chunk, ChunkSectionPos(chunk.pos, y))
}
