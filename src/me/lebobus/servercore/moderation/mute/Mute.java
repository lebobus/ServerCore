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

import me.lebobus.servercore.utils.Prefix;

public class Mute implements CommandExecutor, Listener {
	
	public static ArrayList<UUID> muted = new ArrayList<UUID>();
	
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        if (muted.contains(p.getUniqueId())) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You are &bmuted&7."));
        }
        
    }
    
	
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

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
           	
           	    if (muted.contains(target.getUniqueId())) {
        	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is already &bmuted&7."));
        	    	return true;
        	    }
           	    
           	    if (target.isOnline()) {
           	    	target.sendMessage("debug before adding to arraylist");
           	    	muted.add(target.getUniqueId());
           	    	target.sendMessage("debug after adding to arraylist");
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You have been &bmuted&7."));
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has muted&b "+target.getName()+"&7."));
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
           	
           	    if (!muted.contains(target.getUniqueId())) {
           	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+args[0]+"&7 is not &bmuted&7."));
           	    	return true;
           	    }
           	    
           	    if (muted.contains(target.getUniqueId())) {
           	    	muted.remove(target.getUniqueId());
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You have been &bunmuted&7."));
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has &7unmuted&b "+target.getName()+"&7."));
           		    return true;
           	    }

            }
	    }
		
	return true;
	
    }
	
}
