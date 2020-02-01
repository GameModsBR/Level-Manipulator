package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

internal object Buttons: SpecialMapper() {
    override fun postMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (!blockState.id.name.endsWith("_button")) {
            return false
        }

        when(mappedTargetProperties["facing"]) {
             "down" -> {
                mappedTargetProperties["facing"] = "north"
                mappedTargetProperties["face"] = "floor";
            }
            "up" -> {
                mappedTargetProperties["facing"] = "north"
                mappedTargetProperties["face"] = "ceiling";
            }
            else -> {
                mappedTargetProperties["face"] = "wall";
            }
        }

        return true
    }
}
