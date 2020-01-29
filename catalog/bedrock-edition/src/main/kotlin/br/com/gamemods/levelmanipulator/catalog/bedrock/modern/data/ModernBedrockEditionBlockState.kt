package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.SingleLayerCompoundIdentification
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

class ModernBedrockEditionBlockState private constructor(
    override val id: NamespacedIdentification,
    override val state: SingleLayerCompoundIdentification
): BlockState<NamespacedIdentification, SingleLayerCompoundIdentification>() {
    override val catalog get() = ModernBedrockEditionCatalog
    override lateinit var universal: UniversalBlockState

    internal constructor(id: String, state: Map<String, String>?): this(
        NamespacedIdentification(id),
        state.takeUnless { it.isNullOrEmpty() }
            ?.let { SingleLayerCompoundIdentification(it) } ?: SingleLayerCompoundIdentification.EMPTY
    )
}
