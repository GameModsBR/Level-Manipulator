package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionEntityType

object ModernBedrockEditionEntityCatalog: EntityCatalog<
        NamespacedIdentification,
        ModernBedrockEditionEntityType
>() {
    override val catalog get() = ModernBedrockEditionCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
}
