package com.pixelnations.plugin_raid;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Listeners implements Listener {
    String Damager;
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        int id = e.getEntity().getEntityId();

        for (int enemy : Plugin_raid.ENEMY_LISTS) {
            if (enemy == id) {
//                Bukkit.broadcastMessage(String.valueOf("スポーンされたエンティティを攻撃している。" + e.getDamager().getName()));
                Damager = e.getDamager().getName();
            }
        }
    }
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        int id = e.getEntity().getEntityId();
        for (int enemy : Plugin_raid.ENEMY_LISTS) {
            if (enemy == id) {

//                Bukkit.broadcastMessage("エンティティは死んだ。");

                score.ScoreUpdate(Damager);
            }
        }
    }
}
