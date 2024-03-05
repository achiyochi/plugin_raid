package com.pixelnations.plugin_raid;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Map;
import java.util.Objects;

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
        task.runTaskTimer(Plugin_raid.getPlugin(), 0L, 60 * 20);
    }

    public static void RaidStart(Map date) {
        if (date.get("minute").equals(0)) {

            for (Player player : Bukkit.getOnlinePlayers()) {
                String inWorld = String.valueOf(player.getWorld().getName());
                
                player.sendTitle("襲撃が開始されます！", "覚悟の準備をしておいて下さい。", 10, 100, 10);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1, 1);



                for (int i = 0; i < 10; i++) {
                    Location location = player.getLocation();
//                    double y = location.getY();

//                    Score score = objective.getScore(player.getName());
//                    score.setScore(42);


                    Map vec = Calendar.GenRandom();

                    double x = (double) vec.get("x");
                    double z = (double) vec.get("z");

                    Block isBlock = location.clone().add(x, 1, z).getBlock();
//                    Block isBlock5 = location.clone().add(x, 1, z).getBlock();
//                    player.sendMessage(String.valueOf(isBlock.getType()));

                    for (int j = 0; j < 100; j++) {
                        if (!Objects.equals(String.valueOf(isBlock.getType()), "AIR") || !Objects.equals(String.valueOf(isBlock.getType()), "WATER")) {
                            vec = Calendar.GenRandom();
                            x = (double) vec.get("x");
                            z = (double) vec.get("z");
                            isBlock = location.clone().add(x, 1, z).getBlock();
                        }
                    }

                    PotionEffect WATER_BREATHING = new PotionEffect(PotionEffectType.WATER_BREATHING, 60000, 10);
                    PotionEffect FIRE_RESISTANCE = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 60000, 10);
                    PotionEffect GLOWING = new PotionEffect(PotionEffectType.GLOWING, 60000, 10);
                    PotionEffect HEALTH_BOOST = new PotionEffect(PotionEffectType.HEALTH_BOOST, 6000, 20);
                    PotionEffect SPEED = new PotionEffect(PotionEffectType.SPEED, 60000, 10);

                    if (Objects.equals(inWorld, "world_nether")) {
                        if (!Objects.equals(String.valueOf(isBlock.getType()), "AIR")) {
                            Entity e = location.getWorld().spawnEntity(location.add(0, 1, 0), EntityType.PIGLIN_BRUTE);
                            Entity e2 = location.getWorld().spawnEntity(location.add(0, 1, 0), EntityType.HOGLIN);
                            GLOWING.apply((LivingEntity) e);
                            GLOWING.apply((LivingEntity) e2);
                            HEALTH_BOOST.apply((LivingEntity) e);
                            HEALTH_BOOST.apply((LivingEntity) e2);
                            SPEED.apply((LivingEntity) e);
                            SPEED.apply((LivingEntity) e2);
                            FIRE_RESISTANCE.apply((LivingEntity) e);
                            FIRE_RESISTANCE.apply((LivingEntity) e2);
                        } else {
                            Entity e = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.PIGLIN_BRUTE);
                            Entity e2 = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.HOGLIN);
                            GLOWING.apply((LivingEntity) e);
                            GLOWING.apply((LivingEntity) e2);
                            HEALTH_BOOST.apply((LivingEntity) e);
                            HEALTH_BOOST.apply((LivingEntity) e2);
                            SPEED.apply((LivingEntity) e);
                            SPEED.apply((LivingEntity) e2);
                            FIRE_RESISTANCE.apply((LivingEntity) e);
                            FIRE_RESISTANCE.apply((LivingEntity) e2);
                        }
                    } else if (Objects.equals(inWorld, "world")) {
                        if (!Objects.equals(String.valueOf(isBlock.getType()), "AIR") && !Objects.equals(String.valueOf(isBlock.getType()), "WATER")) {
                            Entity e = location.getWorld().spawnEntity(location.add(0, 1, 0), EntityType.PILLAGER);
                            GLOWING.apply((LivingEntity) e);
                            Block isBlockInWater = location.clone().add(0, 1, 0).getBlock();
                            if (Objects.equals(String.valueOf(isBlockInWater.getType()), "WATER")) {
                                WATER_BREATHING.apply((LivingEntity) e);
                            }
                        } else if (Objects.equals(String.valueOf(isBlock.getType()), "WATER")){
                            Entity e = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.PILLAGER);
                            WATER_BREATHING.apply((LivingEntity) e);
                            GLOWING.apply((LivingEntity) e);
                        } else {
                            Entity e = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.PILLAGER);
                            GLOWING.apply((LivingEntity) e);
                        }
                    }





//                    if (isBlock.isEmpty() == false) {
//                        Map vec2 = com.pixelnations.plugin_raid.Calendar.GenRandom();
//                        double x2 = (double) vec.get("x");
//                        double z2 = (double) vec.get("z");
//                        Block isBlock2 = location.clone().add(x2, 2, z2).getBlock();
//
//                        if (isBlock2.isEmpty() == false) {
//                            Map vec3 = com.pixelnations.plugin_raid.Calendar.GenRandom();
//                            double x3 = (double) vec.get("x");
//                            double z3 = (double) vec.get("z");
//                            Block isBlock3 = location.clone().add(x3, 3, z3).getBlock();
//
//                            if (isBlock3.isEmpty() == false) {
//                                Entity e = location.getWorld().spawnEntity(location.add(0, 1, 0), EntityType.PILLAGER);
//                            } else {
//                                Entity e = location.getWorld().spawnEntity(location.add(x3, 3, z3), EntityType.PILLAGER);
//                            }
//
//                        } else {
//                            Entity e = location.getWorld().spawnEntity(location.add(x2, 2, z2), EntityType.PILLAGER);
//                        }
//                    } else {
//                        Entity e = location.getWorld().spawnEntity(location.add(x, 1, z), EntityType.PILLAGER);
//                    }

//                    player.sendMessage(String.valueOf(isBlock.isEmpty()));

                }
            }
        }
    }
}
