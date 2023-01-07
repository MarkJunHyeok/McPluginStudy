package study.plugin.listener;

import be.seeseemelk.mockbukkit.block.BlockMock;
import org.junit.jupiter.api.Test;
import study.plugin.support.ListenerTest;

import static org.bukkit.Material.EMERALD_BLOCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlockBreakListenerTest extends ListenerTest {

    @Override
    public void setListener() {
        server.getPluginManager().registerEvents(new BlockBreakListener(), plugin);
    }

    @Test
    void 플레이어가_블럭을_부시면_블럭의_이름을_말함() {
        BlockMock block = new BlockMock();
        block.setType(EMERALD_BLOCK);

        player.simulateBlockBreak(block);

        String playerMessage = player.nextMessage();

        assertEquals(playerMessage, EMERALD_BLOCK.name());
    }

    @Test
    void 플레이어가_블럭을_부시면_오피로_설정됨() {
        player.simulateBlockBreak(new BlockMock());

        assertTrue(player.isOp());
    }
}
