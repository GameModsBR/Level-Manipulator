package br.com.gamemods.levelmanipulator.catalog.java.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.TileEntityType
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

class ModernJavaEditionTileEntityType internal constructor(
    override val id: NamespacedIdentification
) : TileEntityType<NamespacedIdentification>() {
    override val catalog get() = LegacyJavaEditionCatalog
    override lateinit var universal: UniversalTileEntityType
}
