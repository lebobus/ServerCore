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

        if (h == null && c != null && l != null && b != null) {
            return "helmet";
        }
        if (h != null && c == null && l != null && b != null) {
            return "chestplate";
        }
        if (h != null && c != null && l == null && b != null) {
            return "leggings";
        }
        if (h != null && c != null && l != null && b == null) {
            return "boots";
        }

        return "";
    }

    private boolean fullArmor(Player p) {
        ItemStack h = p.getInventory().getHelmet();
        ItemStack c = p.getInventory().getChestplate();
        ItemStack l = p.getInventory().getLeggings();
        ItemStack b = p.getInventory().getBoots();

        if (h == null && c == null && l == null && b == null) return false;
        if (h != null && c != null && l != null && b != null) return true;
        return false;
    }

    @EventHandler
    public void onUnequip(PlayerArmorUnequipEvent e) {
        ItemStack i = e.getItemStack();
        if (i == null) return;

        if (missingPiece(e.getPlayer()).equals("helmet") && missingPiece(e.getPlayer()).equals("") && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Fire Resistance I")) {
            if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY + "Health Boost I")) {
                if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY + "Resistance I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("chestplate") && missingPiece(e.getPlayer()).equals("") && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Health Boost I")) {
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY + "Fire Resistance I")) {
                if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY + "Resistance I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("leggings") && missingPiece(e.getPlayer()).equals("") && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY + "Fire Resistance I")) {
                if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY + "Health Boost I")) {
                    if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY + "Speed I")) {
                        e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            }
        }

        if (missingPiece(e.getPlayer()).equals("boots") && missingPiece(e.getPlayer()).equals("") && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Speed I")) {
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
            if (e.getPlayer().getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GRAY+"Fire Resistance I")) {
                if (e.getPlayer().getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GRAY+"Health Boost I")) {
                    if (e.getPlayer().getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
                        if (e.getPlayer().getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GRAY+"Speed I")) {
                            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000, 0));
                        }
                    }
                }
            }
        }
    }

}
