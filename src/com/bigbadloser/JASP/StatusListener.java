package com.bigbadloser.JASP;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.UUID;
public class StatusListener implements Listener{
    private final Main plugin;

    public StatusListener (final Main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void entityDamage(EntityDamageEvent e){
        final UUID uuid = e.getEntity().getUniqueId();

        if (e.getEntity() instanceof Player){
            //POISON ANNOUNCE
            if (e.getCause() == EntityDamageEvent.DamageCause.POISON){
                if ((System.currentTimeMillis() / 1000) - plugin.getLastPoisonTime(uuid) > 120){
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + e.getEntity().getName() + " is " + ChatColor.GREEN + "poisoned!" + ChatColor.DARK_AQUA + " Oh no!");
                    plugin.setLastPoisonTime(uuid, (int) (System.currentTimeMillis() / 1000));
                }
            }
            //DROWN ANNOUNCE
            else if(e.getCause() == EntityDamageEvent.DamageCause.DROWNING){
                if ((System.currentTimeMillis() / 1000) - plugin.getLastDrownTime(uuid) > 120){
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + e.getEntity().getName() + " is " + ChatColor.BLUE + "drowning!" + ChatColor.DARK_AQUA + " Oh no!");
                    plugin.setLastDrowningTime(uuid, (int) (System.currentTimeMillis() / 1000));
                }
            }
            //BURN ANNOUNCE
            else if (e.getCause() == EntityDamageEvent.DamageCause.FIRE){
                if ((System.currentTimeMillis() / 1000) - plugin.getLastFireTime(uuid) > 120) {
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + e.getEntity().getName() + " is " + ChatColor.RED + "burning!" + ChatColor.DARK_AQUA + " Oh no!");
                    plugin.setLastFireTime(uuid, (int) (System.currentTimeMillis() / 1000));
                }
            }
            else if (e.getCause() == EntityDamageEvent.DamageCause.WITHER){
                if ((System.currentTimeMillis() / 1000) - plugin.getLastWitherTime(uuid) > 120) {
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + e.getEntity().getName() + " is " + ChatColor.RED + "withering away!" + ChatColor.BLACK + " Oh no!");
                    plugin.setLastWitherTime(uuid, (int) (System.currentTimeMillis() / 1000));
                }
            }
        }
    }
}

