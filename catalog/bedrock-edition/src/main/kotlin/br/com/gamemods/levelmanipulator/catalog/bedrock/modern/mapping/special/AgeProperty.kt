package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object AgeProperty: SpecialMapper() {
    override fun preMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        when (blockState.id.name) {
            "cactus", "chorus_flower", "cocoa", "fire", "frosted_ice", "kelp", "nether_wart", "reeds" -> {
                mappedOriginProperties += "age"
                mappedTargetProperties["age"] = blockState.state.compound["age"]!!.stringValue
            }
        }

        // Always returning false so other mappers can map other properties
        return false
    }
}
