package br.com.gamemods.levelmanipulator.catalog.api

import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

abstract class Catalog(val namespace: String) {
    abstract val blockStates: BlockStateCatalog<*, *, *>
    abstract val items: ItemCatalog<*, *, *, *>
    abstract val entityTypes: EntityCatalog<*, *>
    abstract val tileEntities: TileEntityCatalog<*, *>
    
    @Throws(IOException::class)
    protected inline fun <R> resourceStream(resource: String, action: (InputStream) -> R): R {
        val stream = this::class.java.getResourceAsStream(resource) ?: throw FileNotFoundException("Resource: $resource")
        return stream.use(action)
    }
    
    protected inline fun <R> resourceReader(resource: String, charset: Charset = Charsets.UTF_8, action: (BufferedReader) -> R): R {
        return resourceStream(resource) {
            action(it.bufferedReader(charset))
        }
    }
}
