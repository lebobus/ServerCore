package me.lebobus.servercore;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.lebobus.servercore.bountyhunter.AssigningTimer;
import me.lebobus.servercore.lootprotect.LootProtectListeners;
import me.lebobus.servercore.moderation.ban.Ban;
import me.lebobus.servercore.moderation.kick.Kick;
import me.lebobus.servercore.moderation.mute.Mute;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.PlayerData;
import me.lebobus.servercore.utils.PluginsHider;

public class Main extends JavaPlugin implements Listener {
	
	public static Main inst;
	private static Plugin plugin; 
	
	private Files data;
	private Files logs;
	private Files bounty;

    public void onEnable() {
	  
        plugin = Bukkit.getPluginManager().getPlugin("Factions");  
	
        registerEvents(this, new Listener[] { this });
        registerEvents(this, new Listener[] { new Ban(), new Mute(), new PlayerData(), new PluginsHider(), new LootProtectListeners(), new AssigningTimer() });
    
        getCommand("ban").setExecutor(new Ban());
        getCommand("unban").setExecutor(new Ban());
        getCommand("kick").setExecutor(new Kick());
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new Mute());

        data = new Files(getDataFolder(), "data.yml");
        logs = new Files(getDataFolder(), "logs.yml");
        bounty = new Files(getDataFolder(), "bounty.yml");
     
        if (!data.fileExists()) {
             data.createFile();
             data.loadFile();
             data.saveFile();
        }
    
        if (!logs.fileExists()) {
             logs.createFile();
             logs.loadFile();
             logs.saveFile();
        }
    
        if (!bounty.fileExists()) {
             bounty.createFile();
             bounty.loadFile();
             bounty.saveFile();
        }
    
        this.data.loadFile();
        this.logs.loadFile();
        this.bounty.loadFile();
    
        inst = this;
    
        plugin = this;
    
    }
  
    public void onDisable() {
    	
	    data = new Files(getDataFolder(), "data.yml");
        logs = new Files(getDataFolder(), "logs.yml");
        bounty = new Files(getDataFolder(), "bounty.yml");
	  
        this.data.loadFile();
        this.data.saveFile();
	  
        this.logs.loadFile();
        this.logs.saveFile();
	  
        this.bounty.loadFile();
        this.bounty.saveFile();

        plugin = null;
    }
  
    public static void registerEvents(Plugin plugin, Listener... listeners) {
        Listener[] arrayOfListener;
        int j = (arrayOfListener = listeners).length;
        for (int i = 0; i < j; i++) {
             Listener listener = arrayOfListener[i];
             Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
  
    public static Plugin getPlugin() {
        return plugin;
    }
  
}