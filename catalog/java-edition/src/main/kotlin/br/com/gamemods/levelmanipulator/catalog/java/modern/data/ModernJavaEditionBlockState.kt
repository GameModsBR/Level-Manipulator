package br.com.gamemods.levelmanipulator.catalog.java.modern.data

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState

class ModernJavaEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: StringKeyValueIdentification
): BlockState<NamespacedIdentification, StringKeyValueIdentification>() {
    override lateinit var universal: UniversalBlockState
}