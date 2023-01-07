package study.plugin.listener;

import be.seeseemelk.mockbukkit.entity.PufferFishMock;
import org.junit.jupiter.api.Test;
import study.plugin.support.ListenerTest;

import java.util.UUID;

import static study.plugin.support.Simulation.simulateFishing;

class PlayerFishListenerTest extends ListenerTest {

    public void setListener() {
        server.getPluginManager().registerEvents(new PlayerFishListener(), plugin);
    }

    @Test
    void 플레이어가_물고기를_낚으면_물고기_이름을_말함() {
        PufferFishMock pufferFishMock = new PufferFishMock(server, UUID.randomUUID());

        simulateFishing(server, player, pufferFishMock);

        player.assertSaid(pufferFishMock.getName());
    }
}
