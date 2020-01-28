package br.com.gamemods.levelmanipulator.catalog.universal

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification

class UniversalBlockState(
    override val id: NamespacedIdentification,
    override val state: StringKeyValueIdentification
): BlockState<NamespacedIdentification, StringKeyValueIdentification>() {
    override val universal get() = this

    override fun toString(): String {
        return "UniversalBlockState(id=$id, state=$state)"
    }
}
