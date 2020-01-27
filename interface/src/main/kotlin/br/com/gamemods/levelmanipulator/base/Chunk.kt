package br.com.gamemods.levelmanipulator.base

abstract class Chunk(open val region: Region, val pos: ChunkPos): Vector2i by pos, InWorld by region
