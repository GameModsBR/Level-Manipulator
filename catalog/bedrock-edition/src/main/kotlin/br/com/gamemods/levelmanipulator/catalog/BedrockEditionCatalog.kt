package br.com.gamemods.levelmanipulator.catalog

class BedrockEditionCatalog: Catalog() {
    override val blockStates = BlockStateCatalog(BedrockEditionBlockState::class)
    override val items = ItemCatalog(BedrockEditionItem::class)
    override val entityTypes = EntityCatalog(BedrockEditionEntityType::class)
}
