package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionTileEntityType

class ModernJavaEditionTileEntityCatalog private constructor(catalog: ModernJavaEditionCatalog): TileEntityCatalog<
        ModernJavaEditionCatalog,
        NamespacedIdentification,
        ModernJavaEditionTileEntityType
>(ModernJavaEditionCatalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: ModernJavaEditionCatalog) = ModernJavaEditionTileEntityCatalog(catalog)
    }
}
