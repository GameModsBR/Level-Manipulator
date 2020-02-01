package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.SingleLayerCompoundIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object BambooSapling: SpecialMapper() {
    override fun postMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (blockState.id.name != "bamboo_sapling") {
            return false
        }

        if (blockState.state != SingleLayerCompoundIdentification("age_bit-0b;sapling_type-\"acacia\"")) {
            shouldReverseBind.set(false)
        }

        // Discard this data, it is useless in this block
        mappedTargetProperties -= "stage"
        mappedTargetProperties -= "material"

        return true
    }
}
