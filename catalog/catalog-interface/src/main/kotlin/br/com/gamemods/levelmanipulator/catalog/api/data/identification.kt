package br.com.gamemods.levelmanipulator.catalog.api.data

import br.com.gamemods.nbtmanipulator.*

/**
 * Object which holds an identifier code for a type, like block ids, item ids and entity ids.
 */
sealed class Identification {
    /**
     * Return a string which fully represent this identification.
     */
    abstract override fun toString(): String

    companion object {
        /**
         * Constructs the appropriate identification type using a given string and the scope type.
         */
        @JvmStatic
        @JvmName("from")
        inline operator fun <reified Id: Identification> invoke(str: String): Id {
            return when(Id::class) {
                NumericalIdentification::class -> NumericalIdentification(
                    str.toInt()
                )
                NamespacedIdentification::class -> NamespacedIdentification(
                    str
                )
                StringIdentification::class -> StringIdentification(
                    str
                )
                SingleLayerCompoundIdentification::class -> SingleLayerCompoundIdentification(
                    str
                )
                StringKeyValueIdentification::class -> StringKeyValueIdentification(
                    str
                )
                else -> throw IllegalArgumentException("Unsupported identification type: ${Id::class.java.name}")
            } as Id
        }
    }
}

/**
 * Simple int id.
 */
data class NumericalIdentification(val id: Int): Identification() {
    override fun toString(): String {
        return id.toString()
    }
}

/**
 * An id like `minecraft:stone`.
 */
data class NamespacedIdentification(val namespace: String, val name: String): Identification() {
    private constructor(parts: List<String>): this(parts[0], parts[1])
    constructor(joined: String): this(joined.split(':', limit = 2).also {
        require(it.size == 2) {
            "Invalid namespaced id: $joined"
        }
    })
    override fun toString(): String {
        return "$namespace:$name"
    }
}

/**
 * A simple string which is not namespaced. Like `Creeper`.
 */
data class StringIdentification(val id: String): Identification() {
    override fun toString(): String {
        return id
    }
}

/**
 * A key-pair identification where both keys and values are always strings, the order doesn't matter.
 */
class StringKeyValueIdentification(map: Map<String, String>): Identification() {
    private val internalMap = map.toMap()
    val map get() = internalMap.toMap()

    private constructor(original: String, entries: List<String>): this(entries.asSequence().map {
        val entry = it.split('-', limit = 2)
        check(entry.size == 2) {
            "Invalid string key-value id: $original"
        }
        check(entries.none(String::isEmpty)) {
            "Invalid string key-value id: $original, contains empty association."
        }
        entry[0] to entry[1]
    }.toMap())
    constructor(joined: String): this(joined, joined.split(';'))

    override fun toString(): String {
        return internalMap.asSequence().map { "${it.key}-${it.value}" }.joinToString(";")
    }
}

/**
 * A NBT compound tag which is only one layer deep (doesn't have lists, arrays or other compounds in it).
 */
class SingleLayerCompoundIdentification(compound: NbtCompound): Identification() {
    init {
        require(compound.values.none { it is NbtList<*> || it is NbtCompound || it is NbtByteArray || it is NbtIntArray || it is NbtLongArray || it == NbtEnd }) {
            "Invalid single layer compound identification, a list, an array or a compound has been found: $compound"
        }
    }
    private val nbt = compound.deepCopy()
    val compound get() = nbt.deepCopy()

    private constructor(original: String, entries: List<String>): this(NbtCompound(*entries.map {
        val entry = it.split('-', limit = 2)
        check(entry.size == 2) {
            "Invalid string key-value id: $original"
        }
        check(entries.none(String::isEmpty)) {
            "Invalid string key-value id: $original, contains empty association."
        }
        var str = entry[1]
        val type = str.last()
        str = str.substring(0, str.lastIndex)
        val tag = when (type) {
            'I' -> NbtInt(str.toInt())
            'B' -> NbtByte(str.toByte())
            'S' -> NbtShort(str.toShort())
            'L' -> NbtLong(str.toLong())
            'D' -> NbtDouble(str.toDouble())
            '\"' -> {
                check(str.length > 2) {
                    "Invalid string key-value id: $original, contains empty association."
                }
                check(str.first() == '\"') {
                    "Invalid string value, doesn't have the first quote: $original"
                }
                NbtString(str.substring(1))
            }
            else -> error("Unexpected type with code $type: $original")
        }
        entry[0] to tag
    }.toTypedArray()))
    constructor(joined: String): this(joined, joined.split(';'))

    override fun toString(): String {
        return nbt.asSequence().map { (key, nbt) ->
            val value = when (nbt) {
                is NbtInt -> "${nbt.value}I"
                is NbtByte -> "${nbt.value}B"
                is NbtShort -> "${nbt.value}S"
                is NbtLong -> "${nbt.value}L"
                is NbtFloat -> "${nbt.value}F"
                is NbtDouble -> "${nbt.value}D"
                is NbtString -> {
                    val str = nbt.value
                    check('\"' !in str) {
                        "String tags may not have the \" character! $nbt"
                    }
                    check(';' !in str) {
                        "String tags may not have the ; character! $nbt"
                    }
                    "\"$str\""
                }
                else -> error("Unexpected value type: $nbt")
            }
            "$key-$value"
        }.joinToString(";")
    }
}
