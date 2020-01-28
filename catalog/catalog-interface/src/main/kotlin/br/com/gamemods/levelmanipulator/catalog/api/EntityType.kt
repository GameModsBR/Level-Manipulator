package br.com.gamemods.levelmanipulator.catalog.api

abstract class EntityType<IdType: Identification> {
    abstract val id: IdType

    fun component1() = id

    override fun toString(): String {
        return "EntityType(id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EntityType<*>

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
