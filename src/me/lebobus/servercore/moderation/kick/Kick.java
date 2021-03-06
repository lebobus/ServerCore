package me.lebobus.servercore.moderation.kick;

import me.lebobus.servercore.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lebobus.servercore.moderation.logs.Logs;

public class Kick implements CommandExecutor {
	
	private Logs logs = new Logs();
	private Prefix prefix = new Prefix();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!sender.hasPermission("core.kick")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 1) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/kick &7[&bplayer&7]"));
                    return true;
            }
            
            
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 1) {
            	
            	if (target == null) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+args[0]+"&7 is not &bonline&7."));
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/kick &7[&bplayer&7]"));
            		return true;
            	}
            	
            	if (target.isOnline()) {
            		logs.createLog((Player)sender, target, "kick", "N/A", null);
            		((Player) target).kickPlayer(ChatColor.translateAlternateColorCodes('&', "&7You have been &bkicked&7."));
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has kicked&b "+target.getName()+"&7."));
            		return true;
            	}

            }
            
            
            
		}
	    return true;
    }
}
