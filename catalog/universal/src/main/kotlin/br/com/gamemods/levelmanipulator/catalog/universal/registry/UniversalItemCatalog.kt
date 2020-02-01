package br.com.gamemods.levelmanipulator.catalog.universal.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.ItemCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem

class UniversalItemCatalog private constructor(catalog: UniversalCatalog): ItemCatalog<
        UniversalCatalog,
        NamespacedIdentification,
        StringKeyValueIdentification,
        UniversalBlockState,
        UniversalItem
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun get(id: String, data: String?) = get(NamespacedIdentification(id), data?.let { StringKeyValueIdentification(it) })

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: UniversalCatalog) = UniversalItemCatalog(catalog)
    }
}
