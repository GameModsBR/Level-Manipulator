package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object FacingDirectionStartingOn2: SpecialMapper() {
    private val specialIds = setOf(
        "glazed_terracotta", "blast_furnace", "furnace", "smoker", "chest", "ender_chest", "hopper"
    )

    override fun postMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (universalBlockId.name !in specialIds) {
            return false
        }

        when (mappedTargetProperties["facing"]) {
            "down", "up" -> {
                mappedTargetProperties["facing"] = "south"
                shouldReverseBind.set(false)
            }
        }

        return true
    }
}
