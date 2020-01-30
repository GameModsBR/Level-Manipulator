package br.com.gamemods.levelmanipulator.catalog.api.data

import br.com.gamemods.nbtmanipulator.*
import java.util.*

/**
 * Object which holds an identifier code for a type, like block ids, item ids and entity ids.
 */
sealed class Identification: Comparable<Identification> {
    /**
     * Return a string which fully represent this identification.
     */
    abstract override fun toString(): String

    override fun compareTo(other: Identification) = toString().compareTo(other.toString())

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
    constructor(id: String): this(id.toIntOrNull() ?: throw IllegalArgumentException("Invalid numerical identification: $id"))

    override fun toString(): String {
        return id.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NumericalIdentification

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NamespacedIdentification

        if (name != other.name) return false
        if (namespace != other.namespace) return false

        return true
    }

    override fun hashCode(): Int {
        var result = namespace.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }


}

/**
 * A simple string which is not namespaced. Like `Creeper`.
 */
data class StringIdentification(val id: String): Identification() {
    init {
        require(':' !in id) {
            "String identification may not have the ':' character. Use NamespacedIdentification instead."
        }
    }
    override fun toString(): String {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringIdentification

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}

/**
 * A key-pair identification where both keys and values are always strings, the order doesn't matter.
 */
class StringKeyValueIdentification(map: Map<String, String>): Identification() {
    companion object {
        val EMPTY = StringKeyValueIdentification()
    }
    val map: Map<String, String> = Collections.unmodifiableMap(map.toMap())

    constructor(): this(emptyMap())
    
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
        return this.map.asSequence().map { "${it.key}-${it.value}" }.joinToString(";")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringKeyValueIdentification

        if (map != other.map) return false

        return true
    }

    override fun hashCode(): Int {
        return map.hashCode()
    }


}

/**
 * A NBT compound tag which is only one layer deep (doesn't have lists, arrays or other compounds in it).
 */
class SingleLayerCompoundIdentification(compound: NbtCompound): Identification() {
    companion object {
        val EMPTY = SingleLayerCompoundIdentification(NbtCompound())
    }
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
            'i' -> NbtInt(str.toInt())
            'b' -> NbtByte(str.toByte())
            's' -> NbtShort(str.toShort())
            'l' -> NbtLong(str.toLong())
            'd' -> NbtDouble(str.toDouble())
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
    
    constructor(mapped: Map<String, String>): this(NbtCompound(mapped.map { (property, propertyValue) ->
        val dot = property.lastIndexOf('.')
        val propertyName = property.substring(0, dot)
        val tag = when (property[dot + 1]) {
            'b' -> NbtByte(propertyValue.toByte())
            'd' -> NbtDouble(propertyValue.toDouble())
            'f' -> NbtFloat(propertyValue.toFloat())
            'i' -> NbtInt(propertyValue.toInt())
            'l' -> NbtLong(propertyValue.toLong())
            's' -> NbtShort(propertyValue.toShort())
            'c' -> NbtString(propertyValue)
            else -> error("Illegal property key $property")
        }
        propertyName to tag
    }.toMap()))

    override fun toString(): String {
        return nbt.asSequence().map { (key, nbt) ->
            val value = when (nbt) {
                is NbtInt -> "${nbt.value}i"
                is NbtByte -> "${nbt.value}b"
                is NbtShort -> "${nbt.value}s"
                is NbtLong -> "${nbt.value}l"
                is NbtFloat -> "${nbt.value}f"
                is NbtDouble -> "${nbt.value}d"
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SingleLayerCompoundIdentification

        if (nbt != other.nbt) return false

        return true
    }

    override fun hashCode(): Int {
        return nbt.hashCode()
    }


}
