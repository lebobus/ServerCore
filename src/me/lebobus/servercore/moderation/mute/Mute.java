package me.lebobus.servercore.moderation.mute;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;

public class Mute implements CommandExecutor, Listener {
	
	public Files stats;
	
	public static ArrayList<UUID> muted = new ArrayList<UUID>();
	
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        
        stats = new Files(Main.inst.getDataFolder(), "stats.yml");
		stats.loadFile();
        
        if (stats.getBoolean("player."+p.getUniqueId()+".muted") == true) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You are &bmuted&7."));
        }
        
    }
    
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	stats = new Files(Main.inst.getDataFolder(), "stats.yml");
		stats.loadFile();

		if (cmd.getName().equalsIgnoreCase("mute")) {
			if (!sender.hasPermission("core.mute")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1) {
           	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/mute &7[&bplayer&7]"));
                return true;
            }
           
           
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
           	    if (target == null) {
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is not &bonline&7."));
           		    return true;
           	    }
           	
           	    if (stats.getBoolean("player."+target.getUniqueId()+".muted") == true) {
        	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is already &bmuted&7."));
        	    	return true;
        	    }
           	    
           	    if (target.isOnline()) {
           	    	stats.set("player."+target.getUniqueId()+".muted", true);
           	    	stats.saveFile();
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has muted&b "+target.getName()+"&7."));
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You have been &bmuted&7."));
           		    return true;
           	    }

            }
	    }
		
		
		if (cmd.getName().equalsIgnoreCase("unmute")) {
			if (!sender.hasPermission("core.unmute")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1) {
           	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/unmute &7[&bplayer&7]"));
                return true;
            }
           
           
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
           	    if (target == null) {
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is not &bonline&7."));
           		    return true;
           	    }
           	
           	    if (stats.getBoolean("player."+target.getUniqueId()+".muted") == false) {
           	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is not &bmuted&7."));
           	    	return true;
           	    }
           	    
           	    if (stats.getBoolean("player."+target.getUniqueId()+".muted") == true) {
           	    	stats.set("player."+target.getUniqueId()+".muted", false);
           	    	stats.saveFile();
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has &7unmuted&b "+target.getName()+"&7."));
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You have been &bunmuted&7."));
           		    return true;
           	    }

            }
	    }
		
	return true;
	
    }
	
}
