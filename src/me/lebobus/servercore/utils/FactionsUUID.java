package me.lebobus.servercore.utils;

import java.util.Set;

import org.bukkit.entity.Player;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;

import me.lebobus.servercore.Main;

public class FactionsUUID {
	
	protected boolean hasFaction(Player p) {
		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
	    return fPlayer.hasFaction();
	}
	
	public boolean isSameFaction(Player p, Player p2) {
		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
		FPlayer fPlayer2 = FPlayers.getInstance().getByPlayer(p2);
		
		Set<FPlayer> faction1 = fPlayer.getFaction().getFPlayers();
		
		return (faction1.contains(fPlayer) && faction1.contains(fPlayer2));
	}

}
