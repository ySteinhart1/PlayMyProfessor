package com.mygdx.game;

public class Professor {
    //likeability, lecture_skill, consistency, humor, student-engagement
    private int[] stats;
    private int[] resources;


    public Professor(int... starting_stats) throws Exception {
        if(starting_stats.length != Stat.values().length)
            throw new Exception("stats length not same length as stats");
        stats = starting_stats;
        resources = new int[Resource.values().length];
    }

    public enum Stat {
        HUMOR,
        ENGAGEMENT,
        EASINESS,
        ACCESSIBILITY,
        HEALTH
    }

    public enum Resource {
        TA,
        CHALK,
        YERBA,
        LAPTOP
    }

    public void drawStats() {
        for (int i = 0; i < Stat.values().length; i++) {
            Stat stat = Stat.values()[i];
            Graphics.resize(.75f);
            Graphics.drawWord(stat.name() + ": " +  getStat(stat), 1100, 750 - i*35);
            Graphics.resize(1);
        }
        for (int i = 0; i < Resource.values().length; i++) {
            Resource resource = Resource.values()[i];
            Graphics.resize(.75f);
            Graphics.drawWord(resource.name() + ": " +  getResource(resource), 900, 750 - i*35);
            Graphics.resize(1);
        }
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

    public int getResource(Resource resource) {
        return resources[resource.ordinal()];
    }

    public void setResource(Resource resource, int value){
        resources[resource.ordinal()] = value;
    }

    public void changeResource(Resource resource, int value){
        resources[resource.ordinal()] = Math.max(Math.min(resources[resource.ordinal()] + value, 100), 0);
    }


}
