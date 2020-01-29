package levelmanipulator.test.bedrock

import br.com.gamemods.levelmanipulator.catalog.bedrock.modern.ModernBedrockEditionCatalog
import kotlin.test.Test

class Bedrock {
    @Test
    fun testSomeBlocks() {
        val gravel = ModernBedrockEditionCatalog.blockStates["minecraft:gravel"]
        println(gravel)
    }
}