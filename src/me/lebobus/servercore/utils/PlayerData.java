package me.lebobus.servercore.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.lebobus.servercore.Main;

public class PlayerData implements Listener {

	private Files data;
	
	@EventHandler
	public void onJoin(PlayerLoginEvent e) {
		
		Player p = (Player) e.getPlayer();
		
	    data = new Files(Main.inst.getDataFolder(), "data.yml");
		data.loadFile();
		
		if (e.getResult() == Result.KICK_BANNED) {
			data.set("player."+p.getUniqueId()+".name", null);
			data.set("player."+p.getUniqueId()+".muted", null);
			data.set("player."+p.getUniqueId()+".banned", null);
			
			data.set("player."+p.getUniqueId()+".name", p.getName().toString());
			data.set("player."+p.getUniqueId()+".muted", false);
			data.set("player."+p.getUniqueId()+".banned", true);
			data.saveFile();
			return;
        }
		
		if(data.getString("player."+p.getUniqueId().toString()) == null) {
	       data.set("player."+p.getUniqueId()+".name", p.getName().toString());
	       data.set("player."+p.getUniqueId()+".muted", false);
	       data.set("player."+p.getUniqueId()+".banned", false);
	       data.saveFile();
	    } 
    }
	
}
