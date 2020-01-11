package com.mygdx.game;

public class Professor {
    private final int AMOUNT_OF_STATS_TO_CALCULATE = 5;
    //likeability, lecture_skill, consistency, humor, student-engagement
    private final int AMOUNT_OF_OTHER_STATS = 3;
    private int stats_to_calculate; //stats used in calculation of RMP
            //likeability, lecture_skill, time_professor, consistency, grading_time, humor, student_engagement;



    public Professor(int[AMOUNT_OF_STATS] starting_stats) {
        stats = starting_stats;
    }

    private void calculate_RMP() {

    }

    private void fire() {

    }
}
