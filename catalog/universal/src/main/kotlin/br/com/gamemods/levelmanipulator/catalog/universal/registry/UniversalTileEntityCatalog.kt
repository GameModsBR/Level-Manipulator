package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

class UniversalTileEntityCatalog private constructor(catalog: UniversalCatalog): TileEntityCatalog<
        UniversalCatalog,
        NamespacedIdentification,
        UniversalTileEntityType
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: UniversalCatalog) = UniversalTileEntityCatalog(catalog)
    }
}
