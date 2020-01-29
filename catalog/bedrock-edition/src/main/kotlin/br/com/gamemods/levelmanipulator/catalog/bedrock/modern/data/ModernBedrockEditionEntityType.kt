package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalEntityType

class ModernBedrockEditionEntityType(
    override val catalog: LegacyBedrockEditionCatalog,
    override val id: NamespacedIdentification
): EntityType<NamespacedIdentification>() {
    override lateinit var universal: UniversalEntityType
}
