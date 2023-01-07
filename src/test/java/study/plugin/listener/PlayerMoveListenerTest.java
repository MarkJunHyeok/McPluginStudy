package study.plugin.listener;

import be.seeseemelk.mockbukkit.WorldMock;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.junit.jupiter.api.Test;
import study.plugin.support.ListenerTest;

import static org.bukkit.Material.EMERALD_BLOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static study.plugin.fixture.LocationFixture.getLocation;
import static study.plugin.listener.PlayerMoveListener.GENERATE_CUBE_LENGTH;

class PlayerMoveListenerTest extends ListenerTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new PlayerMoveListener(), plugin);
    }

    @Test
    void 플레이어가_걸으면_큐브가_생성됨() {
        WorldMock world = new WorldMock();
        Location location = getLocation(world);

        player.simulatePlayerMove(location);

        큐브_생성(location, world);
    }

    private void 큐브_생성(Location location, World world) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        int cubeXLength = x + GENERATE_CUBE_LENGTH;
        int cubeYLength = y + GENERATE_CUBE_LENGTH;
        int cubeZLength = z + GENERATE_CUBE_LENGTH;

        for (int xPoint = x; xPoint <= cubeXLength; xPoint++) {
            for (int yPoint = y; yPoint <= cubeYLength; yPoint++) {
                for (int zPoint = z; zPoint <= cubeZLength; zPoint++) {
                    Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
                    assertEquals(currentBlock.getType(), EMERALD_BLOCK);
                }
            }
        }
    }
}
