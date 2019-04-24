package me.lebobus.servercore.tags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Clutch implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
            if (e.getEntity().getKiller().getHealth() <= 1.0 && !e.getEntity().getKiller().hasPermission("deluxetags.tag.clutch")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp "+e.getEntity().getKiller().getName()+" deluxetags.tag.clutch");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp "+e.getEntity().getName()+" deluxetags.tag.unlucky");
            }
        }
    }

}
