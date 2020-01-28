package br.com.gamemods.levelmanipulator.catalog.api

abstract class Catalog {
    abstract val blockStates: BlockStateCatalog<*, *, *>
    abstract val items: ItemCatalog<*, *, *, *>
    abstract val entityTypes: EntityCatalog<*, *>
}