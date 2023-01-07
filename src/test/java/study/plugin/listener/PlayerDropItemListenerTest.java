package study.plugin.listener;

import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;
import study.plugin.MainTest;

import static org.bukkit.Material.GOLDEN_SWORD;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static study.plugin.support.Simulation.simulatePlayerDropItem;

class PlayerDropItemListenerTest extends MainTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new PlayerDropItemListener(), plugin);
    }

    @Test
    void 플레이어가_아이템을_버리면_아이템이_변경되어_인벤토리에_들어온다() {
        ItemStack itemStack = new ItemStack(GOLDEN_SWORD);
        player.setItemInHand(itemStack);

        simulatePlayerDropItem(server, player, itemStack);

        ItemStack itemInHand = player.getItemInHand();

        assertNotEquals(itemInHand.getType(), GOLDEN_SWORD);
    }
}
