package com.pixelnations.plugin_raid;

import java.util.*;

public class Calendar {

    public static HashMap<String, Integer> getCalendar() {
        Map date = new HashMap();
        java.util.Calendar nowDate = java.util.Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("Asia/Tokyo");
        nowDate.setTimeZone(tz);
        int h = nowDate.get(java.util.Calendar.HOUR_OF_DAY);
        int m = nowDate.get(java.util.Calendar.MINUTE);
        int s = nowDate.get(java.util.Calendar.SECOND);
        date.put("hour", h);
        date.put("minute", m);
        date.put("second", s);
//                Bukkit.broadcastMessage(String.valueOf(h + "時" + m + "分" + s + "秒") + "襲撃の開始です！");
        return (HashMap<String, Integer>) date;
    }

    public static HashMap<String, Double> GenRandom() {
        Map vec = new HashMap();
        Random rand = new Random();
        double r = rand.nextDouble();
        double PI = Math.PI;
        double num = r * PI * 2.0;
        double v = 24 * Math.sqrt(Math.random());
        double x = v * Math.cos(num) + 8;
        double z = v * Math.sin(num) + 8;
        vec.put("x", x);
        vec.put("z", z);
        return (HashMap<String, Double>) vec;
    }
}
