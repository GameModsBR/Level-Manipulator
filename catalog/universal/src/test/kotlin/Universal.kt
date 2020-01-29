package levelmanupulator.test.universal

import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog
import kotlin.test.Test

class Universal {
    @Test
    fun testSomeBlocks() {
        val gravel = UniversalCatalog.blockStates["universal-minecraft:gravel"]
        println(gravel)
    }
}
