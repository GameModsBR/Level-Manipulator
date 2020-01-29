package br.com.gamemods.levelmanipulator.catalog.universal.data

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog

class UniversalItem private constructor(
    override val id: NamespacedIdentification,
    override val meta: StringKeyValueIdentification?,
    override val block: UniversalBlockState?
) : Item<NamespacedIdentification, StringKeyValueIdentification, UniversalBlockState>() {
    internal constructor(id: String, meta: String? = null, block: UniversalBlockState? = null) : this(
        NamespacedIdentification(id), 
        meta?.let { StringKeyValueIdentification(it) },
        block
    )

    override val catalog get() = UniversalCatalog
    override val universal get() = this


    override fun toString(): String {
        return "UniversalItem(id=$id, meta=${meta?.let{it} ?: '~'}, block=$block)"
    }


}
