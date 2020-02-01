package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object Beehives: SpecialMapper() {
    override fun postMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (universalBlockId.name != "beehive") {
            return false
        }
        val facing = mappedTargetProperties["facing"]
        when (facing) {
            "up", "down" -> mappedTargetProperties["facing"] = "none"
        }
        if (facing == "up") {
            shouldReverseBind.set(false)
        }
        return true
    }
}
