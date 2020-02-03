package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.special

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.SpecialMapper
import java.util.concurrent.atomic.AtomicBoolean

object Lever: SpecialMapper() {
    override fun preMap(
        blockState: ModernBedrockEditionBlockState,
        mappedOriginProperties: MutableSet<String>,
        universalBlockId: NamespacedIdentification,
        mappedTargetProperties: MutableMap<String, String>,
        universalPropertyNames: Set<String>,
        shouldReverseBind: AtomicBoolean
    ): Boolean {
        if (blockState.id.name != "lever") {
            return false
        }

        when (val direction = blockState.state.compound.getString("lever_direction")) {
            "down_east_west" -> {
                mappedTargetProperties["face"] = "floor"
                mappedTargetProperties["facing"] = "west"
            }
            "down_north_south" -> {
                mappedTargetProperties["face"] = "floor"
                mappedTargetProperties["facing"] = "south"
            }
            "up_east_west" -> {
                mappedTargetProperties["face"] = "ceiling"
                mappedTargetProperties["facing"] = "west"
            }
            "up_north_south" -> {
                mappedTargetProperties["face"] = "ceiling"
                mappedTargetProperties["facing"] = "south"
            }
            else -> {
                mappedTargetProperties["face"] = "wall"
                mappedTargetProperties["facing"] = direction
            }
        }

        mappedTargetProperties["powered"] = blockState.state.compound.getBooleanByte("open_bit").toString()
        mappedOriginProperties += "lever_direction"
        mappedOriginProperties += "open_bit"
        return true
    }
}
