package br.com.gamemods.levelmanipulator.catalog.java.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.Item
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.NumericalIdentification
import br.com.gamemods.levelmanipulator.catalog.java.legacy.LegacyJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalItem

class ModernJavaEditionItem internal constructor(
    override val id: NamespacedIdentification,
    override val meta: NumericalIdentification?,
    override val block: ModernJavaEditionBlockState?
) : Item<NamespacedIdentification, NumericalIdentification, ModernJavaEditionBlockState>() {
    override val catalog get() = LegacyJavaEditionCatalog
    override lateinit var universal: UniversalItem
}
