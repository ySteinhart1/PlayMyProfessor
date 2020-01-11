package com.mygdx.game;

public class Professor {
    //likeability, lecture_skill, consistency, humor, student-engagement
    private int[] stats;


    public Professor(int... starting_stats) throws Exception {
        if(starting_stats.length != Stat.values().length)
            throw new Exception("stats length not same length as stats");
        stats = starting_stats;
    }

    public enum Stat {
        HUMOR,
        ENGAGEMENT,
        EASINESS,
        ACCESSIBILITY,
        HEALTH
    }

    public double get_RMP() {
        double count = 0;
        for(int i = 0; i < Stat.values().length-1; i++){
            count += stats[i];
        }
        return count / ((Stat.values().length-1)*20);
    }

    public void setStat(Stat stat, int value) {
        stats[stat.ordinal()] = value;
    }
    public void changeStat(Stat stat, int value) {
        stats[stat.ordinal()] = Math.max(Math.min(stats[stat.ordinal()] + value, 100), 0);
    }

    public int getStat(Stat stat) {
        return stats[stat.ordinal()];
    }


}
