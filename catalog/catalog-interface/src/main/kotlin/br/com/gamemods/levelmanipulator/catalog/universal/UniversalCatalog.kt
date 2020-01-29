package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalBlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalItemCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalTileEntityCatalog

object UniversalCatalog: Catalog("universal") {
    override val blockStates get() = UniversalBlockStateCatalog
    override val items get() = UniversalItemCatalog
    override val entityTypes get() = UniversalEntityCatalog
    override val tileEntities get() = UniversalTileEntityCatalog

    init {
        loadBlockStates()
    }

    private fun loadBlockStates() {
        resourceReader("/levelmanipulator/catalog/universal/block-states.ini") { reader ->
            val properties = mutableMapOf<String, MutableSet<String>>()
            val blockData = mutableMapOf<String, String>()
            fun registerDetailedBlockStates(blockId: String, current: Int = 0, propertyList: List<Pair<String, MutableSet<String>>> = properties.toList()): Boolean {
                if (current < propertyList.size) {
                    val (propertyName, propertyValues) = propertyList[current]
                    for (propertyValue in propertyValues) {
                        blockData[propertyName] = propertyValue
                        if (registerDetailedBlockStates(blockId, current + 1, propertyList)) {
                            val state = UniversalBlockState(blockId, blockData)
                            blockStates += state
                            items += UniversalItem(state.id, state.state, state)
                        }
                    }
                    return false
                }
                return true
            }

            fun registerBlockStates(blockId: String) {
                if (properties.isEmpty()) {
                    val state = UniversalBlockState(blockId)
                    blockStates += state
                    items += UniversalItem(state.id, state.state, state)
                } else {
                    registerDetailedBlockStates(blockId)
                    blockData.clear()
                }
            }

            var currentBlockId: String? = null
            reader.lineSequence().forEach { line ->
                val command = line.trim().takeIf { it.isNotBlank() && it[0] != '#' } ?: return@forEach
                if (command[0] == '[' && command.last() == ']') {
                    currentBlockId?.let {
                        registerBlockStates(it)
                        properties.clear()
                    }
                    currentBlockId = command.substring(1 until command.lastIndex)
                } else {
                    val (propertyName, propertyValues) = command.split('=', limit = 2)
                    val propertyValuesRegistry = properties.getOrPut(propertyName, ::mutableSetOf)
                    propertyValuesRegistry += propertyValues.split(',')
                }
            }
        }
    }
}
