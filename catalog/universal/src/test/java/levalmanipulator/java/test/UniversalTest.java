package levalmanipulator.java.test;

import br.com.gamemods.levelmanipulator.catalog.universal.UniversalCatalog;
import br.com.gamemods.levelmanipulator.catalog.universal.data.UniversalBlockState;
import org.junit.Test;

import java.util.List;

public class UniversalTest {
    @Test
    public void javaAccessTest() {
        final List<UniversalBlockState> states = UniversalCatalog.INSTANCE.getBlockStates().get("minecraft:gravel");
        System.out.println(states);
    }
}
