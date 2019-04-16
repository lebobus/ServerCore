package me.lebobus.servercore.bountyhunter;

import me.lebobus.servercore.utils.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

import me.lebobus.servercore.Main;

public class AssigningTimer implements Listener {

	private Assign assign = new Assign();
	private Prefix prefix = new Prefix();
	
	private boolean timerStarted = false;

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		startTimer();
	}
	
	private void startTimer() {

		if (timerStarted) return;

		if (Bukkit.getOnlinePlayers().size() < 10) { // <-- min player to start timer
			System.out.println(prefix.prefix+"Not enough players to start assigning bounties.");
			return;
		}

		timerStarted = true;
		
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Assigning bounties&7... you have &b1 hour &7to kill your target."));
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			 assign.assignTarget(p);
		}
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7Your time is up, you haven't killed your target."));
                assign.resetBounties();
                timerStarted = false;
                startTimer();
            }
        }, 20*60*60); //20 ticks = 1 second
	}
	
}
