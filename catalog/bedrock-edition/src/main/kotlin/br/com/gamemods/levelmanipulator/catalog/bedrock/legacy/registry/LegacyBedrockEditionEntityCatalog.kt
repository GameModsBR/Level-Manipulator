package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionEntityType

class LegacyBedrockEditionEntityCatalog private constructor(catalog: LegacyBedrockEditionCatalog): EntityCatalog<
        LegacyBedrockEditionCatalog,
        StringIdentification, 
        LegacyBedrockEditionEntityType
>(catalog){
    override fun get(id: String) = get(StringIdentification(id))

    internal companion object {
        @JvmSynthetic operator fun invoke(catalog: LegacyBedrockEditionCatalog) = LegacyBedrockEditionEntityCatalog(catalog)
    }
}
