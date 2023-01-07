package study.plugin.listener;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;
import study.plugin.support.ListenerTest;
import study.plugin.fixture.BlockFixture;

import static org.bukkit.Material.EGG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static study.plugin.support.Simulation.simulateBlockDispense;

class BlockDispenseListenerTest extends ListenerTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new BlockDispenseListener(), plugin);
    }

    @Test
    void 블럭에서_발사되면_발사된_아이템_타입이_변경됨() {
        Block block = BlockFixture.getBlock();
        ItemStack dispenseItem = new ItemStack(EGG);

        simulateBlockDispense(server, block, dispenseItem);

        assertEquals(dispenseItem.getType(), EGG);
    }
}
