package me.lebobus.servercore.moderation.ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;

public class Ban implements CommandExecutor, Listener {

	public Files stats;
	
    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent event){
        if (event.getResult() == Result.KICK_BANNED) {
        	Player p = event.getPlayer();
        	BanList name = Bukkit.getBanList(Type.NAME);
        	BanEntry ban = name.getBanEntry(p.getName());
        	event.setResult(Result.KICK_BANNED);
            event.setKickMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n&7You have been &bbanned&7 by &b"+ban.getSource()+"&7.\n&7Reason: &b"+ban.getReason()+"&7.\n&7Appeal on &bdiscord&7.\n&8&m-+---------------------------------------+-"));
        }
    }
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		stats = new Files(Main.inst.getDataFolder(), "stats.yml");
		stats.loadFile();
		
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (!sender.hasPermission("core.ban")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length > 2 || args.length < 2) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/ban &7[&bplayer&7] [&breason&7]"));
                    return true;
            }
            
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
            if (args.length == 2) {
            	
            	if (stats.getBoolean("player."+target.getUniqueId().toString()+".banned") == true) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+target.getName()+"&7 is already &bbanned&7."));
            		return true;
            	}
	
            	if (args[1] == null) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/ban &7[&bplayer&7] [&creason&7]"));
            		return true;
            	}
            	
            	if (target.isOnline()) {
            		((Player) target).kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n&7You have been &bbanned&7 by &b"+sender.getName()+"&7.\n&7Reason: &b"+args[1]+"&7.\n&7Appeal on &bdiscord&7.\n&8&m-+---------------------------------------+-"));
            	}

            stats.set("player."+target.getUniqueId()+".banned", true);
            stats.saveFile();
            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), args[1], null, sender.getName());
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has banned&b "+target.getName()+" &7for&b "+args[1]+"&7."));
            }
            return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (!sender.hasPermission("core.unban")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
			if (args.length == 0 || args.length > 1) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&7Usage: &b/unban &7[&bplayer&7]"));
                    return true;
            }
            
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
            if (stats.getBoolean("player."+target.getUniqueId().toString()+".banned") == true) {
            	Bukkit.getBanList(BanList.Type.NAME).pardon(target.getName());
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+sender.getName()+" &7has unbanned&b "+target.getName()+"&7."));
            	stats.set("player."+target.getUniqueId()+".banned", false);
            	stats.saveFile();
            } else {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix.prefix+"&b"+target.getName()+"&7 is not &bbanned&7."));
            	return true;
		}
	}
		
    return true;
		
	}
	
	
}
