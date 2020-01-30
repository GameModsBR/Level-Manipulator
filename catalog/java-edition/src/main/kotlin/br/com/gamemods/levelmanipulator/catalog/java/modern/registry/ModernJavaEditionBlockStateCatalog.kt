package br.com.gamemods.levelmanipulator.catalog.java.modern.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.BlockStateCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.ModernJavaEditionCatalog
import br.com.gamemods.levelmanipulator.catalog.java.modern.data.ModernJavaEditionBlockState

object ModernJavaEditionBlockStateCatalog: BlockStateCatalog<
        NamespacedIdentification, 
        StringKeyValueIdentification, 
        ModernJavaEditionBlockState
>() {
    override val catalog get() = ModernJavaEditionCatalog
    override fun get(id: String) = get(NamespacedIdentification(id))
    override fun getIfRegistered(id: String, data: String) = getIfRegistered(NamespacedIdentification(id), StringKeyValueIdentification(data))
}
