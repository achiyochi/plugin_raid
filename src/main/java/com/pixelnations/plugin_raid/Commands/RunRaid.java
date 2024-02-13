package com.pixelnations.plugin_raid.Commands;

import com.pixelnations.plugin_raid.Plugin_raid;
import com.pixelnations.plugin_raid.raid;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class RunRaid implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("plugin_raid.command.runraid") || sender.isOp()) {
//            Timer.countdown();
            Map<String, Integer> date = new HashMap<String, Integer>();
//            Map date = null;
            date.put("hour", 0);
            date.put("minute", 0);
            date.put("second", 0);
            raid.RaidStart(date);
        } else {
            sender.sendMessage(Plugin_raid.noPermission);
        }

        return true;
    }
}