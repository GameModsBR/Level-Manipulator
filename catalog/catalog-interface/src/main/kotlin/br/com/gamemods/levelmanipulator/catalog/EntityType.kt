package br.com.gamemods.levelmanipulator.catalog

abstract class EntityType<IdType: Identification> {
    abstract val id: IdType
}
