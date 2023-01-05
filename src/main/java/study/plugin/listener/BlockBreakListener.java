package study.plugin.listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import study.plugin.Main;

public class BlockBreakListener implements Listener {

    public BlockBreakListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBreakBlockAndPlayerSendMessage(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        player.sendMessage(block.getType().name());
    }

    @EventHandler
    public void onBreakBlockAndPlayerSetOp(BlockBreakEvent event) {
        Player player = event.getPlayer();

        player.setOp(true);
    }
}
