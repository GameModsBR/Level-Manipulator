package br.com.gamemods.levelmanipulator.catalog.api.data

import br.com.gamemods.levelmanipulator.catalog.universal.UniversalEntityType

abstract class EntityType<IdType: Identification> {
    abstract val id: IdType
    abstract val universal: UniversalEntityType

    fun component1() = id
    fun component2() = universal

    override fun toString(): String {
        return "EntityType(id=$id, universal=$universal)"
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
