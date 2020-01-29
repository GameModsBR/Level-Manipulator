package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class ModernBedrockEditionEntityType internal constructor(
    override val id: NamespacedIdentification
): EntityType<NamespacedIdentification>() {
    override val catalog get() = ModernBedrockEditionCatalog
    override lateinit var universal: UniversalEntityType
}
