package me.lebobus.servercore.utils;

import java.util.Set;

import org.bukkit.entity.Player;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import me.lebobus.servercore.Main;

public class FactionsUUID {

	public Main plugin;
	
	public FactionsUUID(Main main){
        this.plugin = main;
    }
	
	protected boolean hasFaction(Player p) {
		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
	    return fPlayer.hasFaction();
	}
	
	public boolean isSameFaction(Player p, Player p2) {
		FPlayer fPlayer = FPlayers.getInstance().getByPlayer((Player)p);
		FPlayer fPlayer2 = FPlayers.getInstance().getByPlayer((Player)p2);
		
		Set<FPlayer> faction1 = fPlayer.getFaction().getFPlayers();
		
		return (faction1.contains(fPlayer) && faction1.contains(fPlayer2));
	}

}