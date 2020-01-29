package br.com.gamemods.levelmanipulator.catalog.universal.data

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog

class UniversalBlockState private constructor(
    override val id: NamespacedIdentification,
    override val state: StringKeyValueIdentification
): BlockState<NamespacedIdentification, StringKeyValueIdentification>() {
    override val catalog get() = UniversalCatalog
    override val universal get() = this
    
    internal constructor(id: String): this(NamespacedIdentification(id), StringKeyValueIdentification.EMPTY)
    internal constructor(id: String, state: String): this(NamespacedIdentification(id), StringKeyValueIdentification(state))

    override fun toString(): String {
        val stateStr = state.toString()
        return "UniversalBlockState(id=$id${if(stateStr.isNotEmpty()) ", state=$stateStr" else ""})"
    }
}
