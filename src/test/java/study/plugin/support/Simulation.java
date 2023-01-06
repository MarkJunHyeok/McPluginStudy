package study.plugin.support;

import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.block.BlockMock;
import be.seeseemelk.mockbukkit.entity.FishHookMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import be.seeseemelk.mockbukkit.plugin.PluginManagerMock;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fish;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.player.PlayerFishEvent;

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
}
