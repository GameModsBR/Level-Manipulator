package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

object UniversalBlockStateCatalog: BlockStateCatalog<
        NamespacedIdentification, StringKeyValueIdentification, UniversalBlockState
>() {
    override val catalog get() = UniversalCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun get(id: String, data: String) = get(NamespacedIdentification(id), StringKeyValueIdentification(data))
}
