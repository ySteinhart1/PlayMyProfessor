package com.mygdx.game;

public class Professor {
    private final int NUM_STATS = 5;
    //likeability, lecture_skill, consistency, humor, student-engagement
    private int[NUM_STATS] stats;
    private int RMP;


    public Professor(int[NUM_STATS] starting_stats) {
        stats = starting_stats;
    }

    public double get_RMP() {
        double count = 0;
        for(int i = 0; i < NUM_STATS; i++){
            count += stats[i];
        }
        return count / (NUM_STATS*20);

    }

    private void fire() {


    }
}
