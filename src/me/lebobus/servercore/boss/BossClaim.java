package me.lebobus.servercore.boss;

import com.massivecraft.factions.*;
import me.lebobus.servercore.utils.FactionsUUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BossClaim implements Listener, CommandExecutor {

    private FactionsUUID factionsUUID = new FactionsUUID();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("test")) {
            Player p = (Player)sender;
            factionsUUID.forceClaimLand(p, new Location(Bukkit.getWorld("node1"), -6991, 64, -6991));
            p.sendMessage("overclaimed debug");
        }
        return true;
    }

}
