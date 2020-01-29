package levelmanupulator.test.universal

import br.com.gamemods.levelmanipulator.catalog.HumanStringComparator
import java.io.File
import java.util.*

fun main() {
    val file = File("catalog/catalog-interface/src/main/resources/levelmanipulator/catalog/universal/block-states.ini")
    sort(file)
}

private fun sort(file: File) {
    val comparator = HumanStringComparator()
    val registry = TreeMap<String, TreeMap<String, TreeSet<String>>>(comparator)
    var currentBlock: String? = null
    file.bufferedReader().useLines { seq  -> 
        seq.forEach { line -> 
            val trimmed = line.trim().takeIf { it.isNotEmpty() && it[0] != '#' } ?: return@forEach
            if (trimmed[0] == '[') {
                currentBlock = trimmed
                registry[trimmed] = TreeMap(comparator)
            } else {
                val (propertyName, propertyValues) = trimmed.split('=', limit = 2)
                val propertyValuesList = propertyValues.split(',')
                registry[currentBlock!!]!![propertyName] = TreeSet(comparator).apply { 
                    addAll(propertyValuesList)
                }
            }
        }
    }
    file.bufferedWriter().use { writer ->
        registry.forEach { (blockName, properties) -> 
            writer.write(blockName)
            writer.newLine()
            properties.forEach { (propertyName, propertyValues) -> 
                writer.write(propertyName)
                writer.write("=")
                writer.write(propertyValues.joinToString(","))
                writer.newLine()
            }
            writer.newLine()
        }
    }
}
