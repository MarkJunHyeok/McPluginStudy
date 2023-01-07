package study.plugin.listener;

import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;
import study.plugin.MainTest;

import static org.bukkit.Material.EMERALD_BLOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static study.plugin.fixture.BlockFixture.getBlock;

class BlockDamageListenerTest extends MainTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new BlockDamageListener(), plugin);
    }
    @Test
    void 블럭을_부수면_플레이어가_들고있는_아이템_이름을_말함() {
        ItemStack itemStack = new ItemStack(EMERALD_BLOCK);

        player.setItemInHand(itemStack);

        player.simulateBlockDamage(getBlock());

        assertEquals(player.nextMessage(), itemStack.getType().name());
    }
}
