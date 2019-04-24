package me.lebobus.servercore.customenchants;

import com.inkzzz.spigot.armorevent.PlayerArmorEquipEvent;
import com.inkzzz.spigot.armorevent.PlayerArmorUnequipEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Resistance implements Listener {

    Material[] armorTypes = {Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS};

    @EventHandler
    public void onUnequip(PlayerArmorUnequipEvent e) {
        ItemStack i = e.getItemStack();

        if (i.getType() == Material.DIAMOND_LEGGINGS) {
            if (i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
                e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            }
        }
    }

    @EventHandler
    public void onEquip(PlayerArmorEquipEvent e) {
        ItemStack i = e.getItemStack();

        if (e.getPlayer().hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) return;
        if (i.getType() == Material.DIAMOND_LEGGINGS) {
            if (i.hasItemMeta() && i != null && i.getItemMeta().getLore().contains(ChatColor.GRAY+"Resistance I")) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 0));
            }
        }
    }

}
