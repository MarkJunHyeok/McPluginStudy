package study.plugin;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import study.plugin.listener.*;

import java.io.File;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public Main() {
        super();
    }

    protected Main(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }
}
