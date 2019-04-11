package me.lebobus.servercore.utils;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.BanList.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.lebobus.servercore.Main;

public class PlayerData implements Listener {

	public Files stats;
	
	@EventHandler
	public void onJoin(PlayerLoginEvent e) {
		
		Player p = (Player) e.getPlayer();
		
		
	    stats = new Files(Main.inst.getDataFolder(), "stats.yml");
		stats.loadFile();

		
		if (e.getResult() == Result.KICK_BANNED) {
			stats.set("player."+p.getUniqueId()+".name", null);
			stats.set("player."+p.getUniqueId()+".muted", null);
			stats.set("player."+p.getUniqueId()+".banned", null);
			
			stats.set("player."+p.getUniqueId()+".name", p.getName().toString());
			stats.set("player."+p.getUniqueId()+".muted", false);
			stats.set("player."+p.getUniqueId()+".banned", true);
			stats.saveFile();
			return;
        }
		
		
		if(stats.getString("player."+p.getUniqueId().toString()) == null) {
	       stats.set("player."+p.getUniqueId()+".name", p.getName().toString());
	       stats.set("player."+p.getUniqueId()+".muted", false);
	       stats.set("player."+p.getUniqueId()+".banned", false);
	       stats.saveFile();
	    } 
    }
	
}
