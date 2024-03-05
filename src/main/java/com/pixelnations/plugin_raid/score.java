package com.pixelnations.plugin_raid;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class score {
    public static void ScoreLunch() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
//        Team team = board.registerNewTeam("raid-challenger");
//        team.setAllowFriendlyFire(true);
//        team.setPrefix("challenger: ");

        Objective objective = board.getObjective("raid-challenge");
        if ( objective == null ) {
            objective = board.registerNewObjective("raid-challenge", "kills");
            objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
            objective.setDisplayName(ChatColor.GREEN + "raid kills");
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            objective.getScore(player).setScore((int)player.getHealth());
//            Score score = objective.getScore(ChatColor.GREEN + "kills:");
//            score.setScore((int)player.getHealth());
        }

//            Objective objective = board.registerNewObjective("test", "dummy");
//        Objective objective = board.getObjective("test");
//        objective.setDisplayName("wins");

//        Score score = objective.getScore(p);
//        score.setScore(42);
    }
}
