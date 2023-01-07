package study.plugin.support;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.block.BlockMock;
import be.seeseemelk.mockbukkit.entity.FishHookMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import be.seeseemelk.mockbukkit.plugin.PluginManagerMock;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;
import study.plugin.mock.ItemMock;

import java.util.UUID;

import static org.bukkit.event.player.PlayerFishEvent.State.FISHING;

public class Simulation {

    public static void simulateFishing(ServerMock server, PlayerMock player, Fish fish) {
        FishHookMock fishHookMock = new FishHookMock(server, UUID.randomUUID());
        PlayerFishEvent event = new PlayerFishEvent(player, fish, fishHookMock, FISHING);

        PluginManagerMock pluginManagerMock = new PluginManagerMock(server);
        pluginManagerMock.callEvent(event);
        pluginManagerMock.assertEventFired(PlayerFishEvent.class);
    }

    public static void simulateBlockBurn(ServerMock server, Block block) {
        BlockMock ignitingBlock = new BlockMock(Material.FIRE);
        BlockBurnEvent event = new BlockBurnEvent(block, ignitingBlock);

        PluginManagerMock pluginManagerMock = new PluginManagerMock(server);
        pluginManagerMock.callEvent(event);
        pluginManagerMock.assertEventFired(BlockBurnEvent.class);
    }

    public static void simulateBlockDispense(ServerMock server, Block block, ItemStack dispenseItem) {
        Vector vector = new Vector(1, 1, 1);

        BlockDispenseEvent event = new BlockDispenseEvent(block, dispenseItem, vector);

        PluginManagerMock pluginManagerMock = new PluginManagerMock(server);
        pluginManagerMock.callEvent(event);
        pluginManagerMock.assertEventFired(BlockDispenseEvent.class);
    }

    public static void simulatePlayerDropItem(ServerMock server, Player player, ItemStack dropItem) {
        ItemMock itemMock = new ItemMock();
        itemMock.setItemStack(dropItem);

        PlayerDropItemEvent event = new PlayerDropItemEvent(player, itemMock);

        PluginManagerMock pluginManagerMock = new PluginManagerMock(server);
        pluginManagerMock.callEvent(event);
        pluginManagerMock.assertEventFired(PlayerDropItemEvent.class);
    }
}
