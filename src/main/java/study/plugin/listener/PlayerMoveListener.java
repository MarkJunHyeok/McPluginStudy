package study.plugin.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.Material.EMERALD_BLOCK;

public class PlayerMoveListener implements Listener {

    public final static Material GENERATE_CUBE_BLOCK = EMERALD_BLOCK;
    public final static int GENERATE_CUBE_LENGTH = 10;


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location location = event.getPlayer().getLocation();

        generateCube(location);
    }

    private void generateCube(Location location) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        int cubeXLength = x + GENERATE_CUBE_LENGTH;
        int cubeYLength = y + GENERATE_CUBE_LENGTH;
        int cubeZLength = z + GENERATE_CUBE_LENGTH;

        World world = location.getWorld();

        for (int xPoint = x; xPoint <= cubeXLength; xPoint++) {
            for (int yPoint = y; yPoint <= cubeYLength; yPoint++) {
                for (int zPoint = z; zPoint <= cubeZLength; zPoint++) {
                    Block currentBlock = world.getBlockAt(xPoint, yPoint, zPoint);
                    currentBlock.setType(GENERATE_CUBE_BLOCK);
                }
            }
        }
    }
}
