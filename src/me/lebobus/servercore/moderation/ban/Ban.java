package me.lebobus.servercore.moderation.ban;

import me.lebobus.servercore.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Date;

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
import me.lebobus.servercore.moderation.logs.Logs;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.IntegerCheck;


public class Ban implements CommandExecutor, Listener {

	private Files data;

	private Logs logs = new Logs();
	private IntegerCheck intCheck = new IntegerCheck();
	private Prefix prefix = new Prefix();


    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerLogin(PlayerLoginEvent event){
        if (event.getResult() == Result.KICK_BANNED) {
        	Player p = event.getPlayer();
        	BanList name = Bukkit.getBanList(Type.NAME);
        	BanEntry ban = name.getBanEntry(p.getName());
        	if (ban.getExpiration() == null) {
        		event.setKickMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n\n&7You have been &bbanned&7 by &b"+ban.getSource()+"&7.\n&7Reason: &b"+ban.getReason()+"&7.\n&7Appeal on &bdiscord&7.\n\n&8&m-+---------------------------------------+-"));
        	    return;
        	}
        	if (ban.getExpiration() != null) {
                event.setKickMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n\n&7You have been &bbanned&7 by &b"+ban.getSource()+"&7.\n&7Expires: &b"+ban.getExpiration()+"\n&7Reason: &b"+ban.getReason()+"&7.\n&7Appeal on &bdiscord&7.\n\n&8&m-+---------------------------------------+-"));
        	    return;
        	}        
        }
    }
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		data = new Files(Main.inst.getDataFolder(), "data.yml");
		data.loadFile();
		
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if (!sender.hasPermission("core.ban")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
            if (args.length == 0 || args.length < 3) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/ban &7[&bplayer&7] [&bduration in days&7] [&breason&7]"));
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Example: &b/ban Fortnite 1 Hacking &8(&7-1 for PERMABAN&8)&7."));
                return true;
            }
            
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
            if (args.length >= 3) {
            
            	if (data.getBoolean("player."+target.getUniqueId().toString()+".banned")) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+target.getName()+"&7 is already &bbanned&7."));
            		return true;
            	}

            	if (!intCheck.isInt(args[1])) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/ban &7[&bplayer&7] [&cduration in days&7] [&breason&7]"));
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Example: &b/ban Fortnite 1 Hacking &8(&7-1 for PERMABAN&8)&7."));
            		return true;
            	}
            	
            	Integer arg1 = Integer.parseInt(args[1]);
            	if (arg1 == -1) {
            		StringBuilder buffer = new StringBuilder();
                    for (int i = 2; i < args.length; i++) {
                        buffer.append(' ').append(args[i]);
                    }
                    String s = buffer.toString();
            		
            		data.set("player."+target.getUniqueId()+".banned", true);
                    data.saveFile();
                    logs.createLog((Player)sender, target, "PERMABAN", "N/A", s);
                    Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), s, null, sender.getName());
                    Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has banned&b "+target.getName()+" &7for&b"+s+"&7."));
                    if (target.isOnline()) {
                		((Player) target).kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n\n&7You have been &bbanned&7 by &b"+sender.getName()+"&7.\n&7Reason: &b"+s+"&7.\n&7Appeal on &bdiscord&7.\n\n&8&m-+---------------------------------------+-"));
                	}
                    return true;
            	}
            	
            	StringBuilder buffer = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    buffer.append(' ').append(args[i]);
                }
                String s = buffer.toString();
            	
                Integer arg1duration = Integer.parseInt(args[1]);
            	if (target.isOnline()) {
            		((Player) target).kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8&m-+---------------------------------------+-\n\n&7You have been &bbanned&7 by &b"+sender.getName()+"&7.\n&7Expires: &b"+new Date(System.currentTimeMillis()+arg1duration+(24*60*60*1000))+"&7.\n&7Reason: &b"+s+"&7.\n&7Appeal on &bdiscord&7.\n\n&8&m-+---------------------------------------+-"));
            	}

            data.set("player."+target.getUniqueId()+".banned", true);
            data.saveFile();
            logs.createLog((Player)sender, target, "TEMPBAN", args[1]+" day(s).", s);
            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), s, new Date(System.currentTimeMillis()+arg1duration+(24*60*60*1000)), sender.getName());
            Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has banned&b "+target.getName()+" &7for&b"+s+"&7 for&b "+args[1]+" &7day(s)&7."));
            }
            return true;
		}
		
		
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (!sender.hasPermission("core.unban")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You do not have access to that command."));
				return true;
			}
			
			if (args.length == 0 || args.length > 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Invalid arguments."));
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Usage: &b/unban &7[&bplayer&7]"));
                    return true;
            }
            
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
            if (data.getBoolean("player."+target.getUniqueId().toString()+".banned")) {
            	Bukkit.getBanList(BanList.Type.NAME).pardon(target.getName());
            	Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+sender.getName()+" &7has unbanned&b "+target.getName()+"&7."));
            	data.set("player."+target.getUniqueId()+".banned", false);
            	data.saveFile();
            	logs.createLog((Player)sender, target, "UNBAN", "N/A", null);
            } else {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+target.getName()+"&7 is not &bbanned&7."));
            	return true;
		    }
	    }
		
    return true;
		
	}
	
	
}
