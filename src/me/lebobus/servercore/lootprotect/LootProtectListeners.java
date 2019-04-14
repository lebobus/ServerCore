package me.lebobus.servercore.lootprotect;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import me.lebobus.servercore.Main;
import net.md_5.bungee.api.ChatColor;

public class LootProtectListeners implements Listener {
	
	private boolean usesDamage = false;
	
	private HashMap<UUID, Damagers> damagers = new HashMap<UUID, Damagers>();
	  
	  
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
	    if ((!(e.getEntity() instanceof Player)) && (!(e.getEntity().getKiller() instanceof Player))) {
	        return;
	    }
	    
	    Player player = e.getEntity();
	    
	    if (e.getEntity().getKiller() == null) {
	        return;
	    }
	    
	    if (e.getDrops().isEmpty()) {
	        return;
	    }
	    
	    if (this.damagers.containsKey(player.getUniqueId())) {
	        final Player killer = Bukkit.getPlayer(((Damagers)this.damagers.get(player.getUniqueId())).getTopDamager());
	        for (ItemStack is : e.getDrops()) {
	        	
	             Entity entity = e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), is);
	             if (entity.hasMetadata("LootSteal")) {
	                 entity.removeMetadata("LootSteal", Main.inst);
	             }
	        entity.setMetadata("LootSteal", new FixedMetadataValue(Main.inst, killer.getUniqueId().toString() + " " + System.currentTimeMillis()));
	        }
	        
	        new BukkitRunnable() {
	        	
	            public void run() {
	            	killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dnodepvp &8> &7Your loot is no longer protected."));
	            }
	        }
	        .runTaskLater(Main.inst, 200L);
	    } else {
	    	
	        final Player killer = e.getEntity().getKiller();
	        for (ItemStack is : e.getDrops()) {
	             Entity entity = e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), is);
	             if (entity.hasMetadata("LootSteal")) {
	                 entity.removeMetadata("LootSteal", Main.inst);
	             }
	             entity.setMetadata("LootSteal", new FixedMetadataValue(Main.inst, killer.getUniqueId().toString() + " " + System.currentTimeMillis()));
	           }
	        
	        new BukkitRunnable() {
	            public void run() {	
	            	killer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dnodepvp &8> &7Your loot is no longer protected."));
	            }
	        }
	        .runTaskLater(Main.inst, 200L);
	    }
	    e.getDrops().clear();
	}
	  
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent e) {
		  
	    if (!e.getItem().hasMetadata("LootSteal")) {
	        return;
	    }
	      
	    String value = ((MetadataValue)e.getItem().getMetadata("LootSteal").get(0)).asString();
	    String[] values = value.split(" ");
	      
	    if (e.getPlayer().getUniqueId().toString().equals(values[0])) {
	        return;
	    }
	      
	    if (System.currentTimeMillis() - Long.valueOf(values[1]).longValue() >= 10000L) {
	        return;
	    }
	  e.setCancelled(true);
	}
	  
	  
	@EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		
	    if (!this.usesDamage) {
	        return;
	    }
	    
	    if (!(event.getEntity() instanceof Player)) {
	        return;
	    }
	    
	    if (event.getDamage() == 0.0D) {
	        return;
	    }
	    
	    Player player = (Player)event.getEntity();Player damager = null;
	    if ((event.getDamager() instanceof Arrow)) {
	        Arrow arrow = (Arrow)event.getDamager();
	        if ((arrow.getShooter() instanceof Player)) {
	            damager = (Player)arrow.getShooter();
	        } else {
	            return;
	               }
	        
	    } else if ((event.getDamager() instanceof Snowball)) {
	        Snowball snowball = (Snowball)event.getDamager();
	        if ((snowball.getShooter() instanceof Player)) {
	            damager = (Player)snowball.getShooter();
	        } else {	
	            return;
	               }
	        
	    } else if ((event.getDamager() instanceof Egg)) {
	        Egg egg = (Egg)event.getDamager();
	        if ((egg.getShooter() instanceof Player)) {
	            damager = (Player)egg.getShooter();
	        } else {
	            return;
	               }
	        
	    } else if ((event.getDamager() instanceof Player)) {
            damager = (Player)event.getDamager();
	    } else {
	        return;
	           }
	    
	    if (!this.damagers.containsKey(player.getUniqueId())) {
	        this.damagers.put(player.getUniqueId(), new Damagers());
	    }
	    ((Damagers)this.damagers.get(player.getUniqueId())).addDamage(damager, (int)event.getDamage());
	}
}


