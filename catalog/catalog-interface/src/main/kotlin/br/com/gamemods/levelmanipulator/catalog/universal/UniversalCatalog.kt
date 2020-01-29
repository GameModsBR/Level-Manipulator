package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalItemCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalTileEntityCatalog

object UniversalCatalog: Catalog("universal") {
    var loaded = false; private set

    override val blockStates get() = UniversalBlockStateCatalog
    override val items get() = UniversalItemCatalog
    override val entityTypes get() = UniversalEntityCatalog
    override val tileEntities get() = UniversalTileEntityCatalog

    fun load() {
        check(!loaded) {
            "Already loaded."
        }
        loaded = true
    }

    private fun loadBlockStates() {
        resourceReader("/levelmanipulator/catalog/universal/simple-blocks.txt") { reader ->
            reader.lineSequence().forEach { line ->
                val name = "universal-" + (line.trim().takeIf { it.isNotBlank() } ?: return@forEach)
                val blockState = UniversalBlockState(name)
                blockStates += blockState
                items += UniversalItem(name, block = blockState)
            }
        }
    }
}
