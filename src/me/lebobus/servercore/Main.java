package me.lebobus.servercore;

import me.lebobus.servercore.boss.BossClaim;
import me.lebobus.servercore.boss.Bosses;
import me.lebobus.servercore.bountyhunter.BountyRewards;
import me.lebobus.servercore.customenchants.*;
import me.lebobus.servercore.lottery.LotteryCommand;
import me.lebobus.servercore.lottery.LotteryGUI;
import me.lebobus.servercore.silkspawner.SilkSpawner;
import me.lebobus.servercore.tags.Clutch;
import me.lebobus.servercore.utils.VaultHook;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
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

    public static Economy econ = null;

    private VaultHook vaultHook = new VaultHook();

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public void onEnable() {
	  
        plugin = Bukkit.getPluginManager().getPlugin("Factions");
        plugin = Bukkit.getPluginManager().getPlugin("Vault");
        plugin = Bukkit.getPluginManager().getPlugin("ArmorEventPlugin");

        registerEvents(this, new Listener[] { this });
        registerEvents(this, new Listener[] { new Ban(), new Mute(), new PlayerData(), new PluginsHider(), new LootProtectListeners(), new AssigningTimer(), new BountyRewards(), new SilkSpawner(), new BossClaim(), new Bosses(), new LotteryGUI(), new Speed(), new Clutch(), new HealthBoost(), new Resistance(), new FireResistance(), new Bonus()});

        getCommand("ban").setExecutor(new Ban());
        getCommand("unban").setExecutor(new Ban());
        getCommand("kick").setExecutor(new Kick());
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new Mute());
        getCommand("nodepvpcore55x2").setExecutor(new LotteryCommand());

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

        if (!this.setupEconomy()) {
            this.getLogger().severe("Disabled due to no VaultHook dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        vaultHook.setupPermissions();
        vaultHook.setupChat();

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