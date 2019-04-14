package me.lebobus.servercore.utils;

import me.lebobus.servercore.Main;

public class IntegerCheck {
	
    public Main plugin;
	
	public IntegerCheck(Main main){
        this.plugin = main;
    }
	
	public boolean isInt(String s) {
   	    try {
   	        Integer.parseInt(s);
   	    } catch (NumberFormatException nfe) {
   	        return false;
   	    }
   	 return true;
    }

}
