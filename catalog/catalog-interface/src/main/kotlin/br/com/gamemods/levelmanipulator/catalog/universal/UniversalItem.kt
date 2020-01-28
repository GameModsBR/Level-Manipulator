package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification

class UniversalItem(
    override val id: NamespacedIdentification,
    override val meta: StringKeyValueIdentification?,
    override val block: UniversalBlockState?
) : Item<NamespacedIdentification, StringKeyValueIdentification, UniversalBlockState>() {
    override val universal get() = this


    override fun toString(): String {
        return "UniversalItem(id=$id, meta=$meta, block=$block)"
    }


}
