package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

class UniversalBlockStateCatalog private constructor(catalog: UniversalCatalog): BlockStateCatalog<
        UniversalCatalog,
        NamespacedIdentification,
        StringKeyValueIdentification,
        UniversalBlockState
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun getIfRegistered(id: String, data: String) = getIfRegistered(NamespacedIdentification(id), StringKeyValueIdentification(data))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: UniversalCatalog) = UniversalBlockStateCatalog(catalog)
    }
}
