package me.lebobus.servercore.bountyhunter;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.FactionsUUID;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;
import net.md_5.bungee.api.ChatColor;

public class Assign {
	
	private Files bounty;
	protected FactionsUUID faction;
	protected Prefix prefix;
	public Main plugin;
	
	public Assign(Main main){
        this.plugin = main;
    }
	
	private Player getRandomPlayer() {
		int random = new Random().nextInt(Bukkit.getServer().getOnlinePlayers().size());
		return (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
	}
	
	private void setBounty(Player hunter, Player target) {
		bounty = new Files(Main.inst.getDataFolder(), "bounty.yml");
		bounty.loadFile();
		
		bounty.set(hunter.getUniqueId()+".name", hunter.getName());
		bounty.set(hunter.getUniqueId()+".target", target.getName());
		bounty.saveFile();
	}
	
	protected void assignTarget(Player p) {
		
		final Player randomPlayer = getRandomPlayer();
		
		if (randomPlayer.getName().equals(p.getName())) {
			p.sendMessage(randomPlayer.getName());
			assignTarget(p);
			return;
		}
		
		if (this.faction.isSameFaction(p, randomPlayer)) {
			p.sendMessage(p.getName() + randomPlayer.getName()+"same faction, reassigning...");
			assignTarget(p);
			return;
		}
		
		setBounty(p, randomPlayer);
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.prefix+"&7You haveeeeeeeeeeeeee been assigned:&b "+ randomPlayer.getName()+"&7."));
		
	}

}
