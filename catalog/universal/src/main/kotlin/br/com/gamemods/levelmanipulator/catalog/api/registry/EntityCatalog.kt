package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.Catalog
import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import java.util.*

abstract class EntityCatalog<
        EntityIdType: Identification,
        EntityTypeClass: EntityType<EntityIdType>
> {
    abstract val catalog: Catalog
    private val registry: SortedMap<EntityIdType, EntityTypeClass> = sortedMapOf()

    operator fun get(id: EntityIdType): EntityTypeClass? = registry[id]
    operator fun get(reference: EntityType<EntityIdType>) = get(reference.id)

    abstract operator fun get(id: String): EntityTypeClass?

    operator fun contains(id: EntityIdType) = id in registry
    operator fun contains(reference: EntityType<EntityIdType>) = contains(reference.id)

    @JvmName("register")
    operator fun plusAssign(entityType: EntityTypeClass) {
        val current = this[entityType]
        require(current == null) {
            "The entity type $entityType is already registered as $current"
        }
        registry[entityType.id] = entityType
    }

    @JvmName("unregister")
    operator fun minusAssign(entityType: EntityTypeClass) {
        registry -= entityType.id
    }

    override fun toString(): String {
        return "EntityCatalog(registry=<${registry.size} entity types>)"
    }

}
