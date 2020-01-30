package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.block

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping.ModernBedrockEditionUniversalMapper
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.registry.UniversalBlockStateCatalog

internal open class MapperModernBedrockBlockDefault(
    val main: ModernBedrockEditionUniversalMapper,
    open val to: String, open val toNamespace: String = main.defaultTargetNamespace
) {
    fun association(blockState: ModernBedrockEditionBlockState): UniversalBlockState {
        check(blockState.state.compound.isEmpty()) {
            "The block state $blockState is not simple and cannot be handled by the default mapper."
        }
        val possibilities = UniversalBlockStateCatalog[NamespacedIdentification(toNamespace, to)]
        when {
            possibilities.isEmpty() -> error("Unable to map $blockState to $toNamespace:$to. Target block is not registered.")
            possibilities.size > 1 -> error("Unable to map $blockState to $toNamespace:$to. Multiple possibilities: $possibilities")
            else -> return possibilities[0]
        }
    }
}
