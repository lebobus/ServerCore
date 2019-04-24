package me.lebobus.servercore.silkspawner;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class SilkSpawner implements Listener {

    private boolean hasSilkTouch(ItemStack tool) {
        if (tool == null) {
            return false;
        }

        if (!tool.containsEnchantment(Enchantment.SILK_TOUCH)) {
            return false;
        }
        return tool.containsEnchantment(Enchantment.SILK_TOUCH);
    }

    @EventHandler
    public void onSpawner(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();

        if (block.getType() != Material.MOB_SPAWNER) {
            return;
        }

        ItemStack heldItem = player.getItemInHand();
        if (heldItem != null) {
            if ((heldItem.getType() == Material.DIAMOND_PICKAXE) || (heldItem.getType() == Material.GOLD_PICKAXE) || (heldItem.getType() == Material.IRON_PICKAXE) || (heldItem.getType() == Material.STONE_PICKAXE) || (heldItem.getType() == Material.WOOD_PICKAXE)) {

                ItemStack tool = player.getItemInHand();
                boolean silkTouch = hasSilkTouch(tool);

                if (silkTouch) {
                    CreatureSpawner cs = (CreatureSpawner) e.getBlock().getState();
                    if (cs.getSpawnedType().equals(EntityType.ZOMBIE)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner zombie 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.SKELETON)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner skeleton 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.SPIDER)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner spider 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.CREEPER)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner creeper 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.ENDERMAN)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner enderman 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.IRON_GOLEM)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner iron_golem 1");
                    }

                    if (cs.getSpawnedType().equals(EntityType.SILVERFISH)) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "stacker give "+e.getPlayer().getName()+" spawner silverfish 1");
                    }

                }

            }

        }


    }

}
