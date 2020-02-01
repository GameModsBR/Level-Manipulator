package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalItemCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalTileEntityCatalog

object UniversalCatalog: Catalog("universal") {
    override val blockStates = UniversalBlockStateCatalog(this)
    override val items = UniversalItemCatalog(this)
    override val entityTypes = UniversalEntityCatalog(this)
    override val tileEntities = UniversalTileEntityCatalog(this)

    init {
        loadBlockStatesIni("/levelmanipulator/catalog/universal/block-states.ini") { blockId, blockData ->
            if (blockData != null) {
                val state = UniversalBlockState(blockId, blockData)
                blockStates += state
                items += UniversalItem(state.id, state.state, state)
            } else {
                val state = UniversalBlockState(blockId)
                blockStates += state
                items += UniversalItem(state.id, state.state, state)
            }
        }
    }

}
