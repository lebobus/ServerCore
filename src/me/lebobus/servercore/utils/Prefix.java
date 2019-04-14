package me.lebobus.servercore.utils;

import org.bukkit.ChatColor;

import me.lebobus.servercore.Main;

public class Prefix {
	
    Main plugin;
	
	public Prefix(Main main){
        this.plugin = main;
    }

	protected String prefix = ChatColor.translateAlternateColorCodes('&', "&dnodepvp &8> ");
	
}
