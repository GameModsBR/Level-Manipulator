package br.com.gamemods.levelmanipulator.catalog.api

import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog

abstract class Catalog {
    abstract val blockStates: BlockStateCatalog<*, *, *>
    abstract val items: ItemCatalog<*, *, *, *>
    abstract val entityTypes: EntityCatalog<*, *>
    abstract val tileEntities: TileEntityCatalog<*, *>
}
