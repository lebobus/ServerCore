package me.lebobus.servercore.lottery;

import me.lebobus.servercore.Main;
import me.lebobus.servercore.moderation.logs.Logs;
import me.lebobus.servercore.utils.Prefix;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LotteryGUI implements Listener {

    private Logs randUtil = new Logs();
    private Prefix prefix = new Prefix();

    public Inventory inv;

    public LotteryGUI() {

        inv = Bukkit.getServer().createInventory(null, 9, ChatColor.AQUA + "55X2 DICE HOST");

        ItemStack first = new ItemStack(Material.PAPER);
        ItemStack second = new ItemStack(Material.PAPER);
        ItemStack third = new ItemStack(Material.PAPER);
        ItemStack fourth = new ItemStack(Material.PAPER);
        ItemStack fifth = new ItemStack(Material.PAPER);
        ItemStack sixth = new ItemStack(Material.PAPER);
        ItemStack seventh = new ItemStack(Material.PAPER);
        ItemStack eighth = new ItemStack(Material.PAPER);
        ItemStack ninth = new ItemStack(Material.PAPER);

        ItemMeta firstmeta = first.getItemMeta();
        ItemMeta secondmeta = second.getItemMeta();
        ItemMeta thirdmeta = third.getItemMeta();
        ItemMeta fourthmeta = fourth.getItemMeta();
        ItemMeta fifthmeta = fifth.getItemMeta();
        ItemMeta sixthmeta = sixth.getItemMeta();
        ItemMeta seventhmeta = seventh.getItemMeta();
        ItemMeta eighthmeta = eighth.getItemMeta();
        ItemMeta ninthmeta = ninth.getItemMeta();

        firstmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$25&7,&b000 &8«"));
        secondmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$50&7,&b000 &8«"));
        thirdmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$100&7,&b000 &8«"));
        fourthmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$250&7,&b000 &8«"));
        fifthmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$500&7,&b000 &8«"));
        sixthmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$1&7,&b000&7,&b000 &8«"));
        seventhmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$2&7,&b500&7,&b000 &8«"));
        eighthmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$5&7,&b000&7,&b000 &8«"));
        ninthmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8» &b$10&7,&b000&7,&b000 &8«"));

        firstmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        secondmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        thirdmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        fourthmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        fifthmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        sixthmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        seventhmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        eighthmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));
        ninthmeta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&7&oRoll higher than &b&o55 &7&oand win &b&ox2&7&o."), ChatColor.translateAlternateColorCodes('&', "&7&oRoll &b&o55 &7&oand win &b&ox5&7&o.")));

        first.setItemMeta(firstmeta);
        second.setItemMeta(secondmeta);
        third.setItemMeta(thirdmeta);
        fourth.setItemMeta(fourthmeta);
        fifth.setItemMeta(fifthmeta);
        sixth.setItemMeta(sixthmeta);
        seventh.setItemMeta(seventhmeta);
        eighth.setItemMeta(eighthmeta);
        ninth.setItemMeta(ninthmeta);

        inv.setItem(0, first);
        inv.setItem(1, second);
        inv.setItem(2, third);
        inv.setItem(3, fourth);
        inv.setItem(4, fifth);
        inv.setItem(5, sixth);
        inv.setItem(6, seventh);
        inv.setItem(7, eighth);
        inv.setItem(8, ninth);

        return;
    }

    public void show(Player p) {
        p.openInventory(inv);
    }



    @EventHandler
    public void onBet(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        ItemStack t = e.getCurrentItem();

        if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
        if (t == null || t.getType() == Material.AIR) return;
        if (t.getItemMeta() == null) return;

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$25&7,&b000 &8«")))) {
            if(Main.econ.has(p, 25000)) {
                Main.econ.withdrawPlayer(p, 25000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 125000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$125&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$125&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 50000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$50&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$25&7,&c000&7."));
                    return;
                }
            }
               p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
               e.setCancelled(true);
               p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$50&7,&b000 &8«")))) {
            if(Main.econ.has(p, 50000)) {
                Main.econ.withdrawPlayer(p, 50000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 250000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$250&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$250&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 100000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$100&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$50&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$100&7,&b000 &8«")))) {
            if(Main.econ.has(p, 100000)) {
                Main.econ.withdrawPlayer(p, 100000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 500000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$250&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$250&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 200000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$200&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$100&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$250&7,&b000 &8«")))) {
            if(Main.econ.has(p, 250000)) {
                Main.econ.withdrawPlayer(p, 250000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 1250000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$1&7,&b250&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$1&7,&b250&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 500000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$500&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$250&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$500&7,&b000 &8«")))) {
            if(Main.econ.has(p, 500000)) {
                Main.econ.withdrawPlayer(p, 500000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 2500000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$2&7,&b500&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$2&7,&b500&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 1000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$1&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$500&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$1&7,&b000&7,&b000 &8«")))) {
            if(Main.econ.has(p, 1000000)) {
                Main.econ.withdrawPlayer(p, 1000000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 5000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$5&7,&b000&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$5&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 2000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$2&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$1&7,&c000&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$2&7,&b500&7,&b000 &8«")))) {
            if(Main.econ.has(p, 2500000)) {
                Main.econ.withdrawPlayer(p, 2500000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 12500000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$12&7,&b500&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$12&7,&b500&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 5000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$5&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$2&7,&c500&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$5&7,&b000&7,&b000 &8«")))) {
            if(Main.econ.has(p, 5000000)) {
                Main.econ.withdrawPlayer(p, 5000000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 15000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$15&7,&b000&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$15&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 10000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$10&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$5&7,&c000&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

        if (t.getItemMeta().getDisplayName().equals((ChatColor.translateAlternateColorCodes('&',  "&8» &b$10&7,&b000&7,&b000 &8«")))) {
            if(Main.econ.has(p, 10000000)) {
                Main.econ.withdrawPlayer(p, 10000000);
                int randomNumber = randUtil.getRandomID(1, 100);
                if (randomNumber == 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 50000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b55 &7and won &b$50&7,&b000&7,&b000&7."));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&b"+p.getName()+" &7rolled &b55 &7and won &b$50&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber > 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    Main.econ.depositPlayer(p, 20000000);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &b"+randomNumber+" &7and won &b$20&7,&b000&7,&b000&7."));
                    return;
                }

                if (randomNumber < 55) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix+"&7You rolled &c"+randomNumber+" &7and lost &c$10&7,&c000&7,&c000&7."));
                    return;
                }
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix.prefix + "&7You don't have enough money."));
            e.setCancelled(true);
            p.closeInventory();
        }

    }


}
