package br.com.gamemods.levelmanipulator.catalog

import br.com.gamemods.nbtmanipulator.NbtCompound

sealed class Identification {
    /**
     * Return a string which fully represent this identification.
     */
    abstract override fun toString(): String
}

data class NumericalIdentification(val id: Int): Identification() {
    override fun toString(): String {
        return id.toString()
    }
}

data class NamespacedIdentification(val namespace: String, val name: String): Identification() {
    override fun toString(): String {
        return "$namespace:$name"
    }
}

data class StringIdentification(val id: String): Identification() {
    override fun toString(): String {
        return id
    }
}

class CompoundIdentification(compound: NbtCompound): Identification() {
    private val nbt = compound.deepCopy()
    val compound get() = nbt.deepCopy()

    override fun toString(): String {
        return nbt.toString()
    }
}
