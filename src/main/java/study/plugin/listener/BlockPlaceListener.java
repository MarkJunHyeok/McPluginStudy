package study.plugin.listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlaceAndPlayerSendMessage(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        String blockName = event.getBlock().getType().name();

        player.sendMessage(blockName);
    }

    @EventHandler
    public void onBlockPlaceOfQuitPlayer(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (currentLocationIsWorldZ(player)) {
            player.kick();
        }
    }

    private boolean currentLocationIsWorldZ(Player player) {
        World world = player.getWorld();

        return world.getName() == "Z";
    }
}
