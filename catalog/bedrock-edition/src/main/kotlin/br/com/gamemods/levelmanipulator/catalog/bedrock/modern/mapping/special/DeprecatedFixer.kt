package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object DeprecatedFixer: SpecialMapper() {
    override fun postMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (blockState.id.name == "bone_block") {
            mappedTargetProperties -= "facing"
            if (blockState.state.compound.getInt("deprecated") != 0) {
                shouldReverseBind.set(false)
            }
            return true
        }

        return false
    }
}
