package br.com.gamemods.levelmanipulator

import br.com.gamemods.levelmanipulator.base.Entity
import br.com.gamemods.levelmanipulator.base.EntityPos
import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification

class McRegionEntity(
    override val chunkSection: McRegionChunkSection,
    type: EntityType<StringIdentification>,
    pos: EntityPos
): Entity<StringIdentification>(chunkSection, type, pos)
