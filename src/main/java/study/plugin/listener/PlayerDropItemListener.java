package study.plugin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import static org.bukkit.Material.DIAMOND_SWORD;

public class PlayerDropItemListener implements Listener {

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        ItemStack dropItem = event.getItemDrop().getItemStack();
        Player player = event.getPlayer();

        changedToDiamondSword(dropItem);

        setItemToPlayerHand(player, dropItem);
    }

    private void changedToDiamondSword(ItemStack item) {
        item.setType(DIAMOND_SWORD);
    }

    private void setItemToPlayerHand(Player player, ItemStack itemStack) {
        PlayerInventory inventory = player.getInventory();

        inventory.setItemInMainHand(itemStack);
    }
}
