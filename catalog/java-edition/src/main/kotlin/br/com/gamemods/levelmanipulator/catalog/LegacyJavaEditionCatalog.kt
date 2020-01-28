package br.com.gamemods.levelmanipulator.catalog

class LegacyJavaEditionCatalog: Catalog() {
    override val blockStates = BlockStateCatalog(LegacyJavaEditionBlockState::class)
    override val items = ItemCatalog(LegacyJavaEditionItem::class)
    override val entityTypes = EntityCatalog(LegacyJavaEditionEntityType::class)
}
