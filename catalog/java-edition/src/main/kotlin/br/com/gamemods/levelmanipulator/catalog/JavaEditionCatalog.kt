package br.com.gamemods.levelmanipulator.catalog

class JavaEditionCatalog: Catalog() {
    override val blockStates = BlockStateCatalog(JavaEditionBlockState::class)
    override val items = ItemCatalog(JavaEditionItem::class)
    override val entityTypes = EntityCatalog(JavaEditionEntityType::class)
}
