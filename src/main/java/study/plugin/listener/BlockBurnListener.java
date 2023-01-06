package study.plugin.listener;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

import static org.bukkit.Material.EGG;

public class BlockBurnListener implements Listener {

    @EventHandler
    public void onBlockBurnAndSetBlockType(BlockBurnEvent event) {
        Block block = event.getBlock();

        block.setType(EGG);
    }
}
