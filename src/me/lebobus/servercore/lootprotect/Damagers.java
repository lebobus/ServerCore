package me.lebobus.servercore.lootprotect;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class Damagers {
	
	protected Long lasthit;
	
	private HashMap<UUID, Integer> damagers = new HashMap<UUID, Integer>(); 
	
	protected void addDamage(Player player, int damage) {
	    if (this.damagers.containsKey(player.getUniqueId())) {
	        this.damagers.put(player.getUniqueId(), Integer.valueOf(((Integer)this.damagers.get(player.getUniqueId())).intValue() + damage));
	    } else {
	        this.damagers.put(player.getUniqueId(), Integer.valueOf(damage));
	           }
	    this.lasthit = Long.valueOf(System.currentTimeMillis());
	}
	  
	
	protected UUID getTopDamager() {
	    UUID player = (UUID)this.damagers.keySet().toArray()[0];
	    for (UUID damager : this.damagers.keySet()) {
	         if (((Integer)this.damagers.get(damager)).intValue() > ((Integer)this.damagers.get(player)).intValue()) {
	             player = damager;
	         }
	    }
	    return player;
	}
	
	
}


