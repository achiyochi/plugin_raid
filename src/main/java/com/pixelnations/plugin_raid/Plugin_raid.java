package com.pixelnations.plugin_raid;

import com.pixelnations.plugin_raid.Commands.RunRaid;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class Plugin_raid extends JavaPlugin {

    private static JavaPlugin plugin;
    public static String noPermission = ChatColor.RED + "※このコマンドを実行するにはOP権限が必要です。";
//    public static  int[] ENEMY_LISTS;
    static List<Integer> ENEMY_LISTS = new ArrayList<Integer>();
    private Listeners Listener;

    @Override
    public void onEnable() {
        // プラグインが起動した時の処理
        plugin = this;

        this.Listener = new Listeners();
        Bukkit.getPluginManager().registerEvents(this.Listener, this);


        com.pixelnations.plugin_raid.score.ScoreLunch();


        com.pixelnations.plugin_raid.raid.RaidObserve();
        getCommand("runraid").setExecutor(new RunRaid());

        super.onEnable();
    }


    @Override
    public void onDisable() {
        // プラグイン停止時の処理
        super.onDisable();
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}

