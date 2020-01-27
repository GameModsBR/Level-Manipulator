package br.com.gamemods.levelmanipulator.base

import br.com.gamemods.levelmanipulator.catalog.EntityType
import br.com.gamemods.levelmanipulator.catalog.Identification

abstract class Entity<IdType: Identification>(
        open val chunkSection: ChunkSection,
        val type: EntityType<IdType>,
        val pos: EntityPos
) : Vector3d by pos, InWorld by chunkSection
