package me.lebobus.servercore.lottery;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LotteryCommand implements CommandExecutor {

    private LotteryGUI lotteryGUI = new LotteryGUI();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (cmd.getName().equalsIgnoreCase("nodepvpcore55x2")) {
            lotteryGUI.show((Player) sender);
        }
        return true;
    }

}
