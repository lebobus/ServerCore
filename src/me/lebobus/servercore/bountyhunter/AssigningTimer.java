package me.lebobus.servercore.bountyhunter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;

import me.lebobus.servercore.Main;

public class AssigningTimer implements Listener {

	private Assign assign;
	
	private boolean timerStarted = false;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if (timerStarted == true) return;
		
		if (!(Bukkit.getOnlinePlayers().size() <= 2)) { // <-- min player to start timer
			startTimer();
			return;
		}
		
	}
	
	protected void startTimer() {

		timerStarted = true;
		
		Bukkit.broadcastMessage("timer started (5 sec)");
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			 this.assign.assignTarget(p);
		}
		
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("timer stopped");
                
            }
        }, 100); //20 ticks = 1 second
	}
	
}
