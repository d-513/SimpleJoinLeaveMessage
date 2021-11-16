package space.d513.plugins.simplejoinleavemessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    private Player lastJoined;
    private Player lastLeft;
    private final SimpleJoinLeaveMessage plugin;
    private static JoinLeaveListener instance;

    public JoinLeaveListener() {
        instance = this;
        this.plugin = SimpleJoinLeaveMessage.getPlugin();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String joinText = plugin.getConfig().getString("messages.join");
        if(plugin.usePAPI) {
            joinText = PlaceholderAPI.setPlaceholders(player, joinText);
        }
        joinText = joinText.replaceAll("&", "§");
        joinText = joinText.replaceAll("\\{name}", player.getName());
        event.setJoinMessage(joinText);
        this.lastJoined = player;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String leaveText = plugin.getConfig().getString("messages.leave");
        if(plugin.usePAPI) {
            leaveText = PlaceholderAPI.setPlaceholders(player, leaveText);
        }
        leaveText = leaveText.replaceAll("&", "§");
        leaveText = leaveText.replaceAll("\\{name}", player.getName());
        event.setQuitMessage(leaveText);
        this.lastLeft = player;
    }

    public static JoinLeaveListener getInstance() {
        return instance;
    }

    public Player getLastJoined() {
        return lastJoined;
    }

    public Player getLastLeft() {
        return lastLeft;
    }
}
