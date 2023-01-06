package study.plugin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.EGG;

public class BlockDispenseListener implements Listener {

    @EventHandler
    public void onBlockDispenseAndChangeItem(BlockDispenseEvent event) {
        ItemStack itemStack = new ItemStack(EGG);

        event.setItem(itemStack);
    }
}
