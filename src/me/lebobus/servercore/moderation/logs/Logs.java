package me.lebobus.servercore.moderation.logs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import me.lebobus.servercore.Main;
import me.lebobus.servercore.utils.Files;

public class Logs {
	
	private Files logs;
	
	public Random rand = new Random();
	 
	public int getRandomID(int min, int max) {
	    return rand.nextInt(max - min) + min;
	}
	
	public void createLog(Player staff, OfflinePlayer victim, String type, String duration, String reason) {
	    Date now = new Date();
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	    String date = format.format(now);
	    
	    int ID = getRandomID(1000000, 2000000);
	    
	    logs = new Files(Main.inst.getDataFolder(), "logs.yml");
		logs.loadFile();
		
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".staff", staff.getName());
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".victim", victim.getName());
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".type", type);
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".duration", duration);
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".reason", reason);
		logs.set("ID-"+ID+"."+staff.getUniqueId()+".date", date);
		logs.saveFile();
	}

}
