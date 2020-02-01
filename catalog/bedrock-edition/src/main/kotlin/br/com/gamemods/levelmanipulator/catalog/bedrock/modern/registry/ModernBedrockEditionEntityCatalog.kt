package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionEntityType

class ModernBedrockEditionEntityCatalog private constructor(catalog: ModernBedrockEditionCatalog): EntityCatalog<
        ModernBedrockEditionCatalog,
        NamespacedIdentification,
        ModernBedrockEditionEntityType
>(catalog) {
    override fun get(id: String) = get(NamespacedIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: ModernBedrockEditionCatalog) = ModernBedrockEditionEntityCatalog(catalog)
    }
}
