package study.plugin.listener;

import be.seeseemelk.mockbukkit.WorldMock;
import org.junit.jupiter.api.Test;
import study.plugin.MainTest;
import study.plugin.fixture.LocationFixture;

import static org.bukkit.Material.AIR;
import static org.bukkit.Material.EMERALD_BLOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlockPlaceListenerTest extends MainTest {

    @Test
    void 플레이어가_블럭을_설치하면_블럭의_이름을_말함() {
        player.simulateBlockPlace(EMERALD_BLOCK, LocationFixture.getLocation());

        assertEquals(player.nextMessage(), EMERALD_BLOCK.name());
    }

    @Test
    void 플레이어가_블럭을_설치한곳이_월드Z라면_킥당함() {
        WorldMock world = new WorldMock(AIR, 1, 100, 100);
        world.setName("Z");

        player.simulateBlockPlace(EMERALD_BLOCK, LocationFixture.getLocation(world));

        assertTrue(player.isEmpty());
    }
}
