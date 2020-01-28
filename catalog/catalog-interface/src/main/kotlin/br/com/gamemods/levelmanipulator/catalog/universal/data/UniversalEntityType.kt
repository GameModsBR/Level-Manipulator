package br.com.gamemods.levelmanipulator.catalog.universal.data

import br.com.gamemods.levelmanipulator.catalog.api.data.EntityType
import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification

class UniversalEntityType(override val id: NamespacedIdentification) : EntityType<NamespacedIdentification>() {
    override val universal get() = this


    override fun toString(): String {
        return "UniversalEntityType(id=$id)"
    }


}
