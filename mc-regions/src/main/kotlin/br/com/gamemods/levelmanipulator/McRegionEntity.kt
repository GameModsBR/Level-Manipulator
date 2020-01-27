package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.*

class McRegionEntity(
    override val chunkSection: McRegionChunkSection,
    type: EntityType<StringIdentification>,
    pos: EntityPos
): Entity<StringIdentification>(chunkSection, type, pos)
