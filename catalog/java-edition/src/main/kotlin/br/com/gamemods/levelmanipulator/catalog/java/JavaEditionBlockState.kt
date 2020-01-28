package br.com.gamemods.levelmanipulator.catalog.java

import br.com.gamemods.levelmanipulator.catalog.api.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.StringKeyValueIdentification

class JavaEditionBlockState(
    override val id: NamespacedIdentification,
    override val state: StringKeyValueIdentification
): BlockState<NamespacedIdentification, StringKeyValueIdentification>()
