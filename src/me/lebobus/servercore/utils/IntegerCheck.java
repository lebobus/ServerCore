package me.lebobus.servercore.utils;

public class IntegerCheck {

	public boolean isInt(String s) {
   	    try {
   	        Integer.parseInt(s);
   	    } catch (NumberFormatException nfe) {
   	        return false;
   	    }
   	 return true;
    }

}
