package br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.StringIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.EntityCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.LegacyBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.bedrock.legacy.data.LegacyBedrockEditionEntityType

class LegacyBedrockEditionEntityCatalog internal constructor(
    override val catalog: LegacyBedrockEditionCatalog
): EntityCatalog<StringIdentification, LegacyBedrockEditionEntityType>(){
    override fun get(id: String) = get(StringIdentification(id))
}
