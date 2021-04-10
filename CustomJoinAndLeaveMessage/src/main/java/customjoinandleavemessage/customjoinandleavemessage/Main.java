package customjoinandleavemessage.customjoinandleavemessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("I start");
        getServer().getPluginManager().registerEvents(this ,this);
        getServer().getPluginManager().registerEvents(this ,this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("I stop");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("JoinMessage").replace("%Player%",e.getPlayer().getDisplayName())));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("LeaveMessage").replace("%Player%",e.getPlayer().getDisplayName())));
    }
}
