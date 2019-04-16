package me.lebobus.servercore.bountyhunter;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BountyRewards implements Listener {

    private Files bounty;
    private Prefix prefix = new Prefix();

    @EventHandler
    public void onTargetKill(PlayerDeathEvent e) {
        if ((e.getEntity() instanceof Player) && (e.getEntity().getKiller() instanceof Player)) {
            bounty = new Files(Main.inst.getDataFolder(), "bounty.yml");
            bounty.loadFile();

            if ((bounty.getString("bounties."+e.getEntity().getKiller().getUniqueId()) != null) && (bounty.getString("bounties."+e.getEntity().getKiller().getUniqueId()+".target").equals(e.getEntity().getName()))) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+e.getEntity().getKiller().getName()+" &7succesfully killed his bounty &8(&b"+e.getEntity().getName()+"&8)&7."));
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "eco give "+e.getEntity().getKiller().getName()+ " 250000");
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "give "+e.getEntity().getKiller().getName()+" creeperegg 3");
                e.getEntity().getKiller().sendMessage(prefix.prefix+"&b3 Creeper Eggs &7have been added your your inventory.");
                bounty.set("bounties."+e.getEntity().getKiller().getUniqueId(), null);
                bounty.saveFile();
            }
        }
    }

}
