package me.lebobus.servercore.moderation.mute;

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
import me.lebobus.servercore.moderation.logs.Logs;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;

public class Mute implements CommandExecutor, Listener {
	
	private Files data;

	private Logs logs = new Logs();
	private Prefix prefix = new Prefix();
	
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        
        data = new Files(Main.inst.getDataFolder(), "data.yml");
		data.loadFile();
        
        if (data.getBoolean("player."+p.getUniqueId()+".muted")) {
            event.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You are &bmuted&7."));
        }
        
    }
    
	
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    	
    	data = new Files(Main.inst.getDataFolder(), "data.yml");
		data.loadFile();

		if (cmd.getName().equalsIgnoreCase("mute")) {
			if (!sender.hasPermission("core.mute")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
           	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/mute &7[&bplayer&7]"));
                return true;
            }
           
           
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
           	    if (target == null) {
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+args[0]+"&7 is not &bonline&7."));
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/mute &7[&bplayer&7]"));
           		    return true;
           	    }
           	
           	    if (data.getBoolean("player."+target.getUniqueId()+".muted")) {
        	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+args[0]+"&7 is already &bmuted&7."));
        	    	return true;
        	    }
           	    
           	    if (target.isOnline()) {
           	    	data.set("player."+target.getUniqueId()+".muted", true);
           	    	data.saveFile();
           	    	logs.createLog((Player)sender, target, "mute", "N/A", null);
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has muted&b "+target.getName()+"&7."));
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You have been &bmuted&7."));
           		    return true;
           	    }

            }
	    }
		
		
		if (cmd.getName().equalsIgnoreCase("unmute")) {
			if (!sender.hasPermission("core.unmute")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
           	    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/unmute &7[&bplayer&7]"));
                return true;
            }
           
           
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
           	    if (target == null) {
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+args[0]+"&7 is not &bonline&7."));
           		    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/unmute &7[&bplayer&7]"));
           		    return true;
           	    }
           	
           	    if (data.getBoolean("player."+target.getUniqueId()+".muted") == false) {
           	    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+args[0]+"&7 is not &bmuted&7."));
           	    	return true;
           	    }
           	    
           	    if (data.getBoolean("player."+target.getUniqueId()+".muted")) {
           	    	data.set("player."+target.getUniqueId()+".muted", false);
           	    	data.saveFile();
           	    	logs.createLog((Player)sender, target, "unmute", "N/A", null);
           		    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has &7unmuted&b "+target.getName()+"&7."));
           		    target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You have been &bunmuted&7."));
           		    return true;
           	    }

            }
	    }
		
	return true;
	
    }
	
}
