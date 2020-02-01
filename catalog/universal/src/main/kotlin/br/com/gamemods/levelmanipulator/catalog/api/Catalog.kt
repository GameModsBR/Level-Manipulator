package br.com.gamemods.levelmanipulator.catalog.api

import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog

abstract class Catalog(val namespace: String) {
    abstract val blockStates: BlockStateCatalog<*, *, *, *>
    abstract val items: ItemCatalog<*, *, *, *, *>
    abstract val entityTypes: EntityCatalog<*, *, *>
    abstract val tileEntities: TileEntityCatalog<*, *, *>
    
    protected fun loadBlockStatesIni(resourcePath: String, registerer: (blockId: String, blockData: Map<String, String>?) -> Unit) {
        resourceReader(resourcePath) { reader ->
            val properties = mutableMapOf<String, MutableSet<String>>()
            val blockData = mutableMapOf<String, String>()
            fun registerDetailedBlockStates(blockId: String, current: Int = 0, propertyList: List<Pair<String, MutableSet<String>>> = properties.toList()): Boolean {
                if (current < propertyList.size) {
                    val (propertyName, propertyValues) = propertyList[current]
                    for (propertyValue in propertyValues) {
                        blockData[propertyName] = propertyValue
                        if (registerDetailedBlockStates(blockId, current + 1, propertyList)) {
                            registerer(blockId, blockData)
                        }
                    }
                    return false
                }
                return true
            }

            fun registerBlockStates(blockId: String) {
                if (properties.isEmpty()) {
                    registerer(blockId, null)
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
