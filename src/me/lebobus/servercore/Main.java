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

import me.lebobus.servercore.moderation.ban.Ban;
import me.lebobus.servercore.moderation.kick.Kick;
import me.lebobus.servercore.moderation.mute.Mute;
import me.lebobus.servercore.utils.Files;
import me.lebobus.servercore.utils.PlayerData;


public class Main extends JavaPlugin implements Listener {
	
	public static Main inst;
	 
	public Files config;
	public Files stats;
	
  private static Plugin plugin;
  
  public void onEnable() {
	  
    registerEvents(this, new Listener[] { this });
    registerEvents(this, new Listener[] { new Ban(), new Mute(), new PlayerData() });
    getCommand("ban").setExecutor(new Ban());
    getCommand("unban").setExecutor(new Ban());
    getCommand("kick").setExecutor(new Kick());
    getCommand("mute").setExecutor(new Mute());
    getCommand("unmute").setExecutor(new Mute());
        
    
    stats = new Files(getDataFolder(), "stats.yml");
     
    if(!stats.fileExists()){
    	stats.createFile();
    	stats.loadFile();
    	stats.saveFile();
    	}
    
    this.stats.loadFile();
    
    inst = this;
    
    plugin = this;
    
  }
  
  public void onDisable() {

	  stats = new Files(getDataFolder(), "stats.yml");
	  
	  this.stats.loadFile();
	  this.stats.saveFile();
	  

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