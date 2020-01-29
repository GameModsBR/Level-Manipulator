package br.com.gamemods.levelmanipulator.catalog.api.data

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

abstract class BlockState<IdType: Identification, StateType: Identification> {
    abstract val catalog: Catalog
    abstract val id: IdType
    abstract val state: StateType
    abstract val universal: UniversalBlockState

    fun component1() = id
    fun component2() = state
    fun component3() = universal

    override fun toString(): String {
        return "BlockState(id=$id, state=$state, universal=$universal)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BlockState<*, *>

        if (id != other.id) return false
        if (state != other.state) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + state.hashCode()
        return result
    }


}
