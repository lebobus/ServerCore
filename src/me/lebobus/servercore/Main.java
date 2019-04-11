package me.lebobus.servercore;

import java.awt.List;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.lebobus.servercore.ban.Ban;
import me.lebobus.servercore.kick.Kick;


public class Main extends JavaPlugin implements Listener {
	
	public static Main inst;
	 
	//public Files config;
	//public Files stats;
	
  private static Plugin plugin;
  
  public void onEnable() {
	  
    registerEvents(this, new Listener[] { this });
    registerEvents(this, new Listener[] { new Ban() });
    getCommand("ban").setExecutor(new Ban());
    getCommand("unban").setExecutor(new Ban());
    getCommand("kick").setExecutor(new Kick());
        
    /*
    config = new Files(getDataFolder(), "config.yml");
    stats = new Files(getDataFolder(), "stats.yml");
    
    
    if(!config.fileExists()){
    	config.createFile();
    	config.loadFile();
    	config.saveFile();
    	}
    	 
    if(!stats.fileExists()){
    	stats.createFile();
    	stats.loadFile();
    	stats.saveFile();
    	}
    
    this.stats.loadFile();
    this.config.loadFile();
 
    FileConfiguration data = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "stats.yml"));
    for (String p : data.getConfigurationSection("player").getKeys(false)) {
    	this.stats = new Files(this.getDataFolder(), "stats.yml");
    	this.stats.loadFile();
    	
    	int i = stats.getInt("player."+p+".kills");

    	Killstreak.kills.put(p, i);
    	
    }
    */
    
    inst = this;
    
    plugin = this;
  }
  
  public void onDisable() {
	  /*
	  config = new Files(getDataFolder(), "config.yml");
	  stats = new Files(getDataFolder(), "stats.yml");
	  
	  this.config.loadFile();
	  this.config.saveFile();
	  
	  this.stats.loadFile();
	  this.stats.saveFile();
	  */

    plugin = null;
  }
  
  public static void registerEvents(Plugin plugin, Listener... listeners) {
	  
    Listener[] arrayOfListener;
    int j = (arrayOfListener = listeners).length;
    for (int i = 0; i < j; i++)
    {
      Listener listener = arrayOfListener[i];
      Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }
  
  public static Plugin getPlugin() {
      return plugin;
  }
  
}