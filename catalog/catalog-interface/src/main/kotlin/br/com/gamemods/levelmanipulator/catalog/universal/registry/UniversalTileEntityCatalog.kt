package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.TileEntityCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalTileEntityType

object UniversalTileEntityCatalog: TileEntityCatalog<NamespacedIdentification, UniversalTileEntityType>() {
    override fun get(id: String) = get(NamespacedIdentification(id))
}
