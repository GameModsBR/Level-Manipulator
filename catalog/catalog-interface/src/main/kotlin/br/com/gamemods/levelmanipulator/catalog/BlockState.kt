package br.com.gamemods.levelmanipulator.catalog

abstract class BlockState<IdType: Identification, StateType: Identification> {
    abstract val id: IdType
    abstract val state: StateType

    fun component1() = id
    fun component2() = state

    override fun toString(): String {
        return "BlockState(id=$id, state=$state)"
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
