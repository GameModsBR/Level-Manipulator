package br.com.gamemods.levelmanipulator.catalog.java.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.legacy.data.LegacyJavaTileEntityType

class LegacyJavaEditionTileEntityCatalog private constructor(catalog: LegacyJavaEditionCatalog): TileEntityCatalog<
        LegacyJavaEditionCatalog,
        StringIdentification,
        LegacyJavaTileEntityType
>(LegacyJavaEditionCatalog) {
    override fun get(id: String) = get(StringIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyJavaEditionCatalog) = LegacyJavaEditionTileEntityCatalog(catalog)
    }
}
