package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import kotlin.reflect.KClass

@Suppress("ConvertSecondaryConstructorToPrimary")
open class EntityCatalog<
        EntityIdType: Identification,
        EntityTypeClass: EntityType<EntityIdType>
> {
    constructor(@Suppress("UNUSED_PARAMETER") stateClass: KClass<EntityTypeClass>)

    private val registry = mutableMapOf<EntityIdType, EntityTypeClass>()

    operator fun get(id: EntityIdType) = registry[id]

    @JvmName("getReifed")
    inline operator fun <reified Id: EntityIdType> get(id: String) = get(Identification<Id>(id))

    operator fun contains(id: EntityIdType) = id in registry

    @JvmName("register")
    operator fun plusAssign(entityType: EntityTypeClass) {
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
