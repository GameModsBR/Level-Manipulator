package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionTileEntityType

object ModernJavaEditionTileEntityCatalog: TileEntityCatalog<
        NamespacedIdentification,
        ModernJavaEditionTileEntityType
>() {
    override val catalog get() = ModernJavaEditionCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
}
