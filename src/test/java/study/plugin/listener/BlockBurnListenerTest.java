package study.plugin.listener;

import be.seeseemelk.mockbukkit.block.BlockMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import study.plugin.support.ListenerTest;

import static org.bukkit.Material.EMERALD_BLOCK;
import static study.plugin.support.Simulation.simulateBlockBurn;

class BlockBurnListenerTest extends ListenerTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new BlockBurnListener(), plugin);
    }
    @Test
    void 블럭이_불에타면_블럭_종류가_변경됨() {
        BlockMock block = new BlockMock(EMERALD_BLOCK);

        simulateBlockBurn(server, block);

        Assertions.assertNotEquals(block.getType(), EMERALD_BLOCK);
    }
}
