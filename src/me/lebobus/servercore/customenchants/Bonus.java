package me.lebobus.servercore.customenchants;

import com.inkzzz.spigot.armorevent.PlayerArmorEquipEvent;
import com.inkzzz.spigot.armorevent.PlayerArmorUnequipEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Bonus implements Listener {

    private String missingPiece(Player p) {
        ItemStack h = p.getInventory().getHelmet();
        ItemStack c = p.getInventory().getChestplate();
        ItemStack l = p.getInventory().getLeggings();
        ItemStack b = p.getInventory().getBoots();

        String missing = "null";

        if (h == null && c != null && l != null && b != null) {
            missing = "helmet";
        }
        if (h != null && c == null && l != null && b != null) {
            missing = "chestplate";
        }
        if (h != null && c != null && l == null && b != null) {
            missing = "leggings";
        }
        if (h != null && c != null && l != null && b == null) {
            missing = "boots";
        }

        return missing;
    }


    private boolean fullArmor(Player p) {
        ItemStack h = p.getInventory().getHelmet();
        ItemStack c = p.getInventory().getChestplate();
        ItemStack l = p.getInventory().getLeggings();
        ItemStack b = p.getInventory().getBoots();

        return (h != null && c != null && l != null && b != null);
    }

    @EventHandler
    public void onUnequip(PlayerArmorUnequipEvent e) {
        ItemStack i = e.getItemStack();

        if (missingPiece(e.getPlayer()).equals("helmet") && i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Fire Resistance I")) {
            if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY + "Health Boost I")) {
                if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY + "Resistance I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("chestplate") && i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Health Boost I")) {
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY + "Fire Resistance I")) {
                if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY + "Resistance I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("leggings") && i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY + "Fire Resistance I")) {
                if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY + "Health Boost I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("boots") && i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Speed I")) {
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY + "Fire Resistance I")) {
                if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY + "Health Boost I")) {
                    if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY + "Resistance I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }


    }

    @EventHandler
    public void onEquip(PlayerArmorEquipEvent e) {
        ItemStack i = e.getItemStack();
        if (i == null) return;

        if (e.getPlayer().getInventory().getHelmet() != null && e.getPlayer().getInventory().getChestplate() != null && e.getPlayer().getInventory().getLeggings() != null && e.getPlayer().getInventory().getBoots() != null) {
            if (i.hasItemMeta() && e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY+"Fire Resistance I")) {
                if (i.hasItemMeta() && e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY+"Health Boost I")) {
                    if (i.hasItemMeta() && e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
                        if (i.hasItemMeta() && e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY+"Speed I")) {
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 0));
                        }
                    }
                }
            }
        }
    }

}
