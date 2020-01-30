@file:JvmName("BlockStateCatalogUtil")
package br.com.gamemods.levelmanipulator.catalog.api.registry

import br.com.gamemods.levelmanipulator.catalog.api.data.BlockState
import br.com.gamemods.levelmanipulator.catalog.api.data.Identification
import br.com.gamemods.levelmanipulator.catalog.api.data.SingleLayerCompoundIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification

@JvmName("getPropertyNamesFromStringKV")
fun <State: BlockState<*, out StringKeyValueIdentification>> BlockStateCatalog<*, *, State>
        .getPropertyNames(id: String): Set<String> {
    val first = (this[id].takeIf { it.isNotEmpty() } ?: throw NoSuchElementException(id)).first()
    return first.state.map.keys
}

@JvmName("getPropertyNamesFromStringKV")
fun <Id: Identification, State: BlockState<Id, out StringKeyValueIdentification>> BlockStateCatalog<Id, *, State>
        .getPropertyNames(id: Id): Set<String> {
    val first = (this[id].takeIf { it.isNotEmpty() } ?: throw NoSuchElementException(id.toString())).first()
    return first.state.map.keys
}


@JvmName("getPropertyNamesFromCompoundData")
fun <State: BlockState<*, out SingleLayerCompoundIdentification>> BlockStateCatalog<*, *, State>
        .getPropertyNames(id: String): Set<String> {
    val first = (this[id].takeIf { it.isNotEmpty() } ?: throw NoSuchElementException(id)).first()
    return first.state.compound.keys
}

@JvmName("getPropertyNamesFromCompoundData")
fun <Id: Identification, State: BlockState<Id, out SingleLayerCompoundIdentification>> BlockStateCatalog<Id, *, State>
        .getPropertyNames(id: Id): Set<String> {
    val first = (this[id].takeIf { it.isNotEmpty() } ?: throw NoSuchElementException(id.toString())).first()
    return first.state.compound.keys
}
