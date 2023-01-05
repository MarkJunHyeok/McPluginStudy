package study.plugin.listener;

import be.seeseemelk.mockbukkit.block.BlockMock;
import org.junit.jupiter.api.Test;
import study.plugin.MainTest;

import static org.bukkit.Material.EMERALD_BLOCK;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlockBreakListenerTest extends MainTest {

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

    @Test
    void 플레이어가_블럭을_부시면_부순_블럭_정보가_변경됨() {
        BlockMock block = new BlockMock();
        block.setType(EMERALD_BLOCK);

        player.simulateBlockBreak(block);

        assertNotEquals(block.getType(), EMERALD_BLOCK);
    }
}
