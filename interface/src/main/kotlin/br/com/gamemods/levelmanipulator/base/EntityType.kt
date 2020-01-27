package br.com.gamemods.levelmanipulator.base

abstract class EntityType<IdType: Identification> {
    abstract val id: IdType
}
