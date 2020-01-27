package br.com.gamemods.levelmanipulator.base

/**
 * A block position relative to the world.
 * 
 * @property layer Bedrock allows multiple blocks to exists in the same space, they are distinct
 * by the layer value. However, only 0 and 1 are officially supported. 0 for normal blocks 
 * and 1 is exclusive to water overlapping waterlogged blocks
 */
data class BlockPos(override val x: Int, override val y: Int, override val z: Int, val layer: Int = 0): Vectors3i {
    val chunkPos get() = ChunkPos(x shr 4, z shr 4)
    val chunkSectionPos get() = ChunkSectionPos(chunkPos, y shr 4)
    val regionPos get() = RegionPos(x shr 9, z shr 9)
}

/**
 * A entity position relative to the world.
 */
data class EntityPos(override val x: Double, override val y: Double, override val z: Double): Vector3d {
    val chunkPos get() = ChunkPos(x.toInt() shr 4, z.toInt() shr 4)
    val chunkSectionPos get() = ChunkSectionPos(chunkPos, y.toInt() shr 4)
    val blockPos get() = BlockPos(x.toInt(), y.toInt(), z.toInt())
    val regionPos get() = RegionPos(x.toInt() shr 9, z.toInt() shr 9)
}

/**
 * A chunk position relative to the world. It represents an entire chunk, with all it's sections.
 */
data class ChunkPos(override val x: Int, override val z: Int): Vector2i {
    val regionPos get() = RegionPos(x shr 5, z shr 5)
}

/**
 * The position of a vertical slice of a chunk. 
 */
data class ChunkSectionPos(val chunkPos: ChunkPos, override val y: Int): Vectors3i {
    constructor(x: Int, y: Int, z: Int): this(ChunkPos(x, z), y)

    override val x get() = chunkPos.x
    override val z get() = chunkPos.z
    val regionPos get() = chunkPos.regionPos
}

/**
 * A region position relative to the world.
 */
data class RegionPos(override val x: Int, override val z: Int): Vector2i
