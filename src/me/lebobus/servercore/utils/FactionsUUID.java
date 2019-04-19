package me.lebobus.servercore.utils;

import java.util.Set;

import com.massivecraft.factions.*;
import com.massivecraft.factions.struct.Relation;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FactionsUUID {

	public void forceClaimLand(Player p, Location loc) {
		if (!hasFaction(p)) return;

		FPlayer fPlayer = FPlayers.getInstance().getByPlayer(p);
		FLocation fLoc = new FLocation(loc);
		Board.getInstance().removeAt(fLoc);
		Board.getInstance().setFactionAt(fPlayer.getFaction(), fLoc);
	}

	public String getFactionName(Player p) {
		String pFaction = FPlayers.getInstance().getByPlayer(p).getFaction().getTag();
		return pFaction;
	}

	public boolean isFriendly(Player a, Player b) {
		Faction pFac = FPlayers.getInstance().getByPlayer(a).getFaction();
		Faction zFac = FPlayers.getInstance().getByPlayer(b).getFaction();
		Relation r = pFac.getRelationTo(zFac);

		if(ChatColor.stripColor(zFac.getId()).equalsIgnoreCase("Wilderness")) return false;
		if(a == b) return true;
		if(r.isEnemy()) return false;
		if(r.isNeutral()) return false;
		if(r.isTruce()) return true;
		if(r.isAlly()) return true;
		if(r.isMember()) return true;
		return false;
	}

	public boolean isInFriendly(Player a, Location location) {
		Faction pFac = FPlayers.getInstance().getByPlayer(a).getFaction();
		FLocation fLoc = new FLocation(location);
		Faction locFac = Board.getInstance().getFactionAt(fLoc);
		Relation r = pFac.getRelationTo(locFac);

		if(ChatColor.stripColor(locFac.getComparisonTag()).equalsIgnoreCase("Wilderness")) return false;
		if(r.isEnemy()) return false;
		if(r.isNeutral()) return false;
		if(r.isTruce()) return true;
		if(r.isAlly()) return true;
		if(r.isMember()) return true;
		return false;
	}

	public boolean isInWarzone(Location location) {
		FLocation fLoc = new FLocation(location);
		Faction locFac = Board.getInstance().getFactionAt(fLoc);

		if(ChatColor.stripColor(locFac.getComparisonTag()).equalsIgnoreCase("WarZone")) return true;
		return false;
	}

	public boolean isInClaimedLand(Location location) {
		FLocation fLoc = new FLocation(location);
		Faction locFac = Board.getInstance().getFactionAt(fLoc);
		String string = ChatColor.stripColor(locFac.getComparisonTag());

		if(string.equalsIgnoreCase("WarZone")) return false;
		if(string.equalsIgnoreCase("SafeZone")) return false;
		if(string.equalsIgnoreCase("Wilderness")) return false;
		return true;
	}

	public boolean hasFaction(Player p) {
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
