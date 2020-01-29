package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionBlockState

class ModernJavaEditionBlockStateCatalog internal constructor(): BlockStateCatalog<NamespacedIdentification, StringKeyValueIdentification, ModernJavaEditionBlockState>() {
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun get(id: String, data: String) = get(NamespacedIdentification(id), StringKeyValueIdentification(data))
}
