package com.pixelnations.plugin_raid;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class raid {

    public static void RaidObserve() {
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                Map date = com.pixelnations.plugin_raid.Calendar.getCalendar();
//                Bukkit.broadcastMessage(String.valueOf(date.get("hour") + "時" + date.get("minute") + "分" + date.get("second") + "秒"));
                raid.RaidStart(date);
            }
        };
        task.runTaskTimer(Plugin_raid.getPlugin(), 0L, 20L);
    }

    public static void RaidStart(Map date) {
        if (date.get("minute").equals(0)) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                
                player.sendTitle("襲撃が開始されます！", "覚悟の準備をしておいて下さい。", 10, 100, 10);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1, 1);

                for (int i = 0; i < 10; i++) {
                    Location location = player.getLocation();
//                    double y = location.getY();

                    Map vec = com.pixelnations.plugin_raid.Calendar.GenRandom();

                    double x = (double) vec.get("x");
                    double z = (double) vec.get("z");

                    Block isBlock = location.clone().add(x, 1, z).getBlock();

                    if (isBlock.isEmpty() == false) {
                        Map vec2 = com.pixelnations.plugin_raid.Calendar.GenRandom();
                        double x2 = (double) vec.get("x");
                        double z2 = (double) vec.get("z");
                        Block isBlock2 = location.clone().add(x2, 2, z2).getBlock();

                        if (isBlock2.isEmpty() == false) {
                            Map vec3 = com.pixelnations.plugin_raid.Calendar.GenRandom();
                            double x3 = (double) vec.get("x");
                            double z3 = (double) vec.get("z");
                            Block isBlock3 = location.clone().add(x3, 3, z3).getBlock();

                            if (isBlock3.isEmpty() == false) {
                                Entity e = location.getWorld().spawnEntity(location.add(0, 1, 0), EntityType.PILLAGER);
                            } else {
                                Entity e = location.getWorld().spawnEntity(location.add(x3, 3, z3), EntityType.PILLAGER);
                            }

                        } else {
                            Entity e = location.getWorld().spawnEntity(location.add(x2, 2, z2), EntityType.PILLAGER);
                        }
                    } else {
                        Entity e = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.PILLAGER);
                    }

//                    player.sendMessage(String.valueOf(isBlock.isEmpty()));



                }
            }
        }
    }

}
