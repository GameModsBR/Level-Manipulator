package br.com.gamemods.levelmanipulator.catalog

abstract class Item<IdType: Identification, MetaType: Identification, BlockType: BlockState<*, *>> {
    abstract val id: IdType
    abstract val meta: MetaType?
    abstract val block: BlockType?

    fun component1() = id
    fun component2() = meta
    fun component3() = block

    override fun toString(): String {
        return "Item(id=$id, meta=$meta, block=$block)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item<*, *, *>

        if (id != other.id) return false
        if (meta != other.meta) return false
        if (block != other.block) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (meta?.hashCode() ?: 0)
        result = 31 * result + (block?.hashCode() ?: 0)
        return result
    }

}
