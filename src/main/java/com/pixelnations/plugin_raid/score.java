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
            Score score = objective.getScore(player);
            int count = score.getScore();
            objective.getScore(player).setScore(count);
//            Score score = objective.getScore(ChatColor.GREEN + "kills:");
//            score.setScore((int)player.getHealth());
        }

//            Objective objective = board.registerNewObjective("test", "dummy");
//        Objective objective = board.getObjective("test");
//        objective.setDisplayName("wins");

//        Score score = objective.getScore(p);
//        score.setScore(42);
    }
    public static void ScoreUpdate(String p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        Objective objective = board.getObjective("raid-challenge");
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName() == p) {
//                Bukkit.broadcastMessage("プレーヤー名が一致していることを確認");
                Score score = objective.getScore(player);
                int count = score.getScore();
//                Bukkit.broadcastMessage(String.valueOf(count));
//                objective.getScore(player).setScore(0);
                objective.getScore(player).setScore(count + 1);
            }
        }
    }
}
