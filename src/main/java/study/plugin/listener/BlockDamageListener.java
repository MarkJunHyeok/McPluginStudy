package study.plugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;

public class BlockDamageListener implements Listener {

    @EventHandler
    public void onBlockDamageAndPlayerSendMessage(BlockDamageEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInHand = event.getItemInHand();

        player.sendMessage(itemInHand.getType().name());
    }
}
