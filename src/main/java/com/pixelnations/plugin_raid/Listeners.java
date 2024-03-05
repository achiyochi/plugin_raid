package com.pixelnations.plugin_raid;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Listeners implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        double damage = e.getDamage();
//        e.setDamage(damage * 2);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(String.valueOf(damage));
        }
    }
}
