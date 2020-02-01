package br.com.gamemods.levelmanipulator.catalog.bedrock.modern.mapping

import br.com.gamemods.levelmanipulator.catalog.api.data.NamespacedIdentification
import br.com.gamemods.levelmanipulator.catalog.api.data.StringKeyValueIdentification
import br.com.gamemods.levelmanipulator.catalog.api.registry.getPropertyNames
import br.com.gamemods.levelmanipulator.catalog.api.resourceProperties
import br.com.gamemods.levelmanipulator.catalog.api.resourceReader
import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.data.ModernBedrockEditionBlockState
import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.LinkedHashMap

internal class UniversalBlockMapper() {
    private val propertyTypes = PropertyTypes()
    private val propertyMapper = PropertyMapper()
    private val blockStateMapper = BlockStateMapper()
    private val specialBlockMappers = listSpecialMappers()

    internal operator fun get(blockState: ModernBedrockEditionBlockState): UniversalBlockState {
        val (fromMapping, toMapping) = blockStateMapper[blockState]
        val (universalBlockId, defaultUniversalProperties) = toMapping
        check(universalBlockId in UniversalCatalog.blockStates) {
            "Unable to map the block state $blockState because the block $universalBlockId is not registered to the universal catalog"
        }
        val propertyNames = UniversalCatalog.blockStates.getPropertyNames(universalBlockId)
        val unregisteredUniversalPropertyNames = (defaultUniversalProperties.map.keys - propertyNames) - "!bind"
        check(unregisteredUniversalPropertyNames.isEmpty()) {
            "The block state $blockState points to an unregistered universal property:\n$unregisteredUniversalPropertyNames"
        }
        val mappedTargetProperties = defaultUniversalProperties.map.toMutableMap()
        val mappedOriginProperties = fromMapping.second.map.keys.toMutableSet()

        val shouldReverseBind = AtomicBoolean((mappedTargetProperties.remove("!bind") ?: "true") == "true")

        specialBlockMappers.any {
            it.preMap(blockState, mappedOriginProperties, universalBlockId, mappedTargetProperties, propertyNames, shouldReverseBind)
        }

        blockState.state.compound.forEach { propertyName, propertyValue ->
            if (propertyName !in mappedTargetProperties && propertyName !in mappedOriginProperties) {
                val (universalPropertyName, universalPropertyValue) = propertyMapper[propertyName, propertyValue.stringValue]
                mappedTargetProperties[universalPropertyName] = universalPropertyValue
                mappedOriginProperties += propertyName
            }
        }

        specialBlockMappers.any {
            it.postMap(blockState, mappedOriginProperties, universalBlockId, mappedTargetProperties, propertyNames, shouldReverseBind)
        }

        val originPropertyNames = blockState.state.compound.keys
        val unmappedOriginProperties = originPropertyNames - mappedOriginProperties
        val unmappedTargetProperties = propertyNames - mappedTargetProperties.keys
        val overmappedOriginProperties = mappedOriginProperties - originPropertyNames
        val overmappedTargetProperties = mappedTargetProperties.keys - propertyNames
        check(unmappedOriginProperties.isEmpty() && unmappedTargetProperties.isEmpty()) {
            "There are properties from $blockState and $universalBlockId which wasn't mapped!\n" +
                "Unmapped Origin: $unmappedOriginProperties\n" +
                "Unmapped Target: $unmappedTargetProperties\n" +
                "Overmapped Origin: $overmappedOriginProperties\n" +
                "Overmapped Target: $overmappedTargetProperties"
        }

        check(overmappedOriginProperties.isEmpty() && overmappedTargetProperties.isEmpty()) {
            "There are more mappings from $blockState to $universalBlockId than it should have!\n" +
                    "Overmapped Origin: $overmappedOriginProperties\n" +
                    "Overmapped Target: $overmappedTargetProperties"
        }

        return UniversalCatalog.blockStates[universalBlockId, StringKeyValueIdentification(mappedTargetProperties)]
    }

    private data class FirstStageMapping(
        val from: Pair<NamespacedIdentification, StringKeyValueIdentification>,
        val to: Pair<NamespacedIdentification, StringKeyValueIdentification>
    )

    private inner class BlockStateMapper() {
        private val mappings = resourceProperties("/levelmanipulator/catalog/bedrock/modern/universal-mappings.properties").asSequence().map {
            it.key.parseMapping("minecraft") to it.value.parseMapping("universal-minecraft")
        }.groupBy { it.first.first }
            .mapValues { v ->
                v.value.map { it.first.second to it.second }
                    .toMap(TreeMap(nullsLast()))
            }

        private fun Any.parseMapping(namespace: String): Pair<NamespacedIdentification, StringKeyValueIdentification?> {
            val parts = toString().split(',', limit = 2)
            val identification = parts.takeIf { it.size == 2 }?.let {
                StringKeyValueIdentification(it[1].replace(',', ';'))
            }
            return NamespacedIdentification(namespace, parts[0]) to identification
        }

        operator fun get(blockState: ModernBedrockEditionBlockState): FirstStageMapping {
            val blockMapping = mappings[blockState.id]
                ?.takeIf { it.isNotEmpty() }
                ?: error("There are no mappings for this block id: $blockState")
            val fromMapping: Pair<NamespacedIdentification, StringKeyValueIdentification?>
            val target: Pair<NamespacedIdentification, StringKeyValueIdentification?>
            if (blockMapping.size == 1) {
                val (from, to) = blockMapping.entries.first()
                check(from == null)
                target = to
                fromMapping = blockState.id to null
            } else {
                val entry = checkNotNull(blockMapping.maxBy { entry ->
                    entry.key?.map?.count { blockState.state.compound[it.key]?.stringValue == it.value } ?: Int.MIN_VALUE
                }) {
                    error("Could not find any mapping for the block state $blockMapping")
                }
                target = entry.value
                fromMapping = blockState.id to entry.key
                /*
                for (entry in blockMapping) {
                    val id = entry.key
                    if (id == null) {
                        target = entry.value
                        fromMapping = blockState.id to null
                        break
                    } else if (id.map.all { blockState.state.compound[it.key]?.stringValue == it.value }) {
                        target = entry.value
                        fromMapping = blockState.id to id
                        break
                    }
                }
                if (target == null) {
                    error("Could not find any mapping for the block state $blockMapping")
                }*/
            }

            return FirstStageMapping(
                fromMapping.first to (fromMapping.second ?: StringKeyValueIdentification.EMPTY),
                target.first to (target.second ?: StringKeyValueIdentification.EMPTY)
            )
        }
    }

    private inner class PropertyMapper() {
        private val mappings = resourceProperties("/levelmanipulator/catalog/bedrock/modern/property-names-mappings.properties")

        operator fun get(propertyName: String, propertyValue: String): Pair<String, String> {
            val tag = mappings.getProperty(propertyName) ?: error("Unmapped property name $propertyName (while parsing the value $propertyValue)")
            val (remappedPropertyName, propertyTypeName) = tag.split(':', limit = 2)
            val propertyType = propertyTypes[propertyTypeName]
            return remappedPropertyName to propertyType[propertyName, propertyValue]
        }
    }

    private abstract inner class PropertyType(val name: String) {
        abstract operator fun get(propertyName: String, propertyValue: String): String
    }

    private inner class SimplePropertyType(name: String, val valueMappings: Map<String, String>): PropertyType(name) {
        override fun get(propertyName: String, propertyValue: String): String {
            return valueMappings[propertyValue] ?: error("Unmapped property value for type $name with property $propertyName and value $propertyValue")
        }
    }

    private inner class PropertyTypes {
        @Suppress("UNCHECKED_CAST")
        private val mappings: Map<String, PropertyType> = resourceReader("/levelmanipulator/catalog/bedrock/modern/properties-types.yml") { reader ->
            val yaml = DumperOptions().let { opt ->
                opt.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
                Yaml(opt)
            }
            (yaml.loadAs(reader, LinkedHashMap::class.java)["types"] as Map<*,*>).asSequence().map {
                val name = it.key.toString()
                name to SimplePropertyType(name, (it.value as Map<*, *>).asSequence().map { e->
                    e.key.toString() to e.value.toString()
                }.toMap())
            }.toMap()
        }

        operator fun get(propertyTypeName: String): PropertyType {
            return mappings[propertyTypeName] ?: error("Unknown property type $propertyTypeName")
        }
    }
}
