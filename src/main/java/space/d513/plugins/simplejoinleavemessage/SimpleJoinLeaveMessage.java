package space.d513.plugins.simplejoinleavemessage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleJoinLeaveMessage extends JavaPlugin {
    private static SimpleJoinLeaveMessage instance;
    public boolean usePAPI;

    @Override
    public void onEnable() {
        // Plugin startup logic
        validateConfig();
        instance = this;
        this.usePAPI = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        if(usePAPI) {
            getLogger().info("Using Placeholderapi");
            new Placeholders().register();
        }
        else {
            getLogger().info("Not using Placeholderapi");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SimpleJoinLeaveMessage getPlugin() {
        return instance;
    }

    private void validateConfig() {
        FileConfiguration config = getConfig();
        if(config.getString("messages.join") == null || config.getString("messages.leave") == null) {
            getLogger().warning("Join or leave is missing in config; quitting");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
