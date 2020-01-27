package br.com.gamemods.levelmanipulator.base

abstract class Entity<IdType: Identification>(
        open val chunkSection: ChunkSection,
        val type: EntityType<IdType>,
        val pos: EntityPos
) : Vector3d by pos, InWorld by chunkSection
