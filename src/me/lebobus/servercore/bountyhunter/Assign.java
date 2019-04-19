package me.lebobus.servercore.bountyhunter;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.FactionsUUID;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;

public class Assign implements Listener {
	
	private Files bounty;
	private FactionsUUID faction = new FactionsUUID();
	private Prefix prefix = new Prefix();

	private Player getRandomPlayer() {
		int random = new Random().nextInt(Bukkit.getServer().getOnlinePlayers().size());
		return (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
	}
	
	private void setBounty(Player hunter, Player target) {
		bounty = new Files(Main.inst.getDataFolder(), "bounty.yml");
		bounty.loadFile();
		
		bounty.set("bounties."+hunter.getUniqueId()+".name", hunter.getName());
		bounty.set("bounties."+hunter.getUniqueId()+".target", target.getName());
		bounty.saveFile();
	}

	void resetBounties() {
		bounty = new Files(Main.inst.getDataFolder(), "bounty.yml");
		bounty.loadFile();

		bounty.set("bounties", null);
		bounty.saveFile();
	}
	
	void assignTarget(Player p) {
		
		final Player randomPlayer = getRandomPlayer();

		if (randomPlayer.getName().equals(p.getName()) || faction.isFriendly(p, randomPlayer) || randomPlayer.getName().equals("LegendMaxqc") || randomPlayer.getName().equals("Boblus") || randomPlayer.getName().equals("flicksha")) {
			assignTarget(p);
			return;
		}

		setBounty(p, randomPlayer);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You have been assigned:&b "+ randomPlayer.getName()+"&7."));
		
	}

}
