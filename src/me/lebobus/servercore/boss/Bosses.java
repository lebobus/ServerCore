package me.lebobus.servercore.boss;

import me.lebobus.servercore.utils.FactionsUUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Bosses implements Listener {

    private FactionsUUID factionsUUID = new FactionsUUID();

    @EventHandler
    public void northEastBoss(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node1")) {
                    if (e.getEntity().getCustomName().contains("North East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node1)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node1"), 6991, 105, -6991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void northWestBoss(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node1")) {
                    if (e.getEntity().getCustomName().contains("North West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node1)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node1"), -6991, 64, -6991));

                    }
                }
            }
        }
    }

    @EventHandler
    public void southEastBoss(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node1")) {
                    if (e.getEntity().getCustomName().contains("South East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node1)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node1"), 6991, 64, 6991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void southWestBoss(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node1")) {
                    if (e.getEntity().getCustomName().contains("South West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node1)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller(), new Location(Bukkit.getWorld("node1"), -6991, 64, 6991));
                    }
                }
            }
        }
    }

//------------------------------

    @EventHandler
    public void northEastBossNether(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node2")) {
                    if (e.getEntity().getCustomName().contains("North East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node2)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node2"), 4991, 72, -4991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void northWestBossNether(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node2")) {
                    if (e.getEntity().getCustomName().contains("North West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node2)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node2"), -4991, 72, -4991));

                    }
                }
            }
        }
    }

    @EventHandler
    public void southEastBossNether(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node2")) {
                    if (e.getEntity().getCustomName().contains("South East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node2)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node2"), 4991, 72, 4991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void southWestBossNether(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node2")) {
                    if (e.getEntity().getCustomName().contains("South West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node2)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller(), new Location(Bukkit.getWorld("node2"), -4991, 72, 4991));
                    }
                }
            }
        }
    }

//------------------------------

    @EventHandler
    public void northEastBossEnd(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node3")) {
                    if (e.getEntity().getCustomName().contains("North East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node3)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node3"), 4991, 72, -4991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void northWestBossEnd(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node3")) {
                    if (e.getEntity().getCustomName().contains("North West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lNorth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lNorth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bNW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node3)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node3"), -4991, 72, -4991));

                    }
                }
            }
        }
    }

    @EventHandler
    public void southEastBossEnd(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node3")) {
                    if (e.getEntity().getCustomName().contains("South East Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth East Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth East Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSE &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node3)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller().getPlayer(), new Location(Bukkit.getWorld("node3"), 4991, 72, 4991));
                    }
                }
            }
        }
    }

    @EventHandler
    public void southWestBossEnd(EntityDeathEvent e) {
        if (e.getEntity() instanceof Zombie) {
            if (e.getEntity().getKiller() instanceof Player) {
                if (e.getEntity().getWorld().getName().equals("node3")) {
                    if (e.getEntity().getCustomName().contains("South West Zombie Boss")) {
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8&m-----&8&l[ &b&lSouth West Zombie Boss&r &bKilled &8&l]&r&8&m-----"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&r"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &b&lSouth West Zombie Boss &7has died!"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7The &bSW &7corner has now been &bclaimed &7by &b"+factionsUUID.getFactionName(e.getEntity().getKiller())+"&7! &8(node3)"));
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&7Killed by: &b"+e.getEntity().getKiller().getName()+"&7."));
                        factionsUUID.forceClaimLand(e.getEntity().getKiller(), new Location(Bukkit.getWorld("node3"), -4991, 72, 4991));
                    }
                }
            }
        }
    }

}
