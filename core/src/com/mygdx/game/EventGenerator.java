package com.mygdx.game;
import java.util.ArrayList;
import java.util.Random;

import com.mygdx.game.Event;
import com.mygdx.game.Professor.Stat;
import com.mygdx.game.Professor.Resource;

public class EventGenerator {
    private static ArrayList<Executable> randomStatChanges;
    private static ArrayList<Executable> randomResourceChanges;
    private static ArrayList<Executable> humorEvents;
    private static ArrayList<Executable> engagementEvents;
    private static ArrayList<Executable> easinessEvents;
    private static ArrayList<Executable> accessibilityEvents;
    private static ArrayList<Executable> healthEvents;

    static Random generator = new Random();


    public static Executable generateEvent(Professor prof) {
        int listToChoose = generator.nextInt(5);

        switch(listToChoose) {
            case 0:
                return generateEventHelper(humorEvents, Stat.HUMOR, prof);
            case 1:
                return generateEventHelper(engagementEvents, Stat.ENGAGEMENT, prof);
            case 2:
                return generateEventHelper(easinessEvents, Stat.EASINESS, prof);
            case 3:
                return generateEventHelper(accessibilityEvents, Stat.ACCESSIBILITY, prof);
            default:
                return generateEventHelper(healthEvents, Stat.HEALTH, prof);
        }
    }

    private static Executable generateEventHelper(ArrayList<Executable> currentEventList, Stat currentStat, Professor prof) {
        int statAmount = prof.getStat(currentStat);
        double normalRange = 100.0/currentEventList.size(); //if it was same chance per event

        int eventToChoose = 0;
        for(; eventToChoose < currentEventList.size()-1; eventToChoose++) {
            int currentRange = (int) Math.floor(normalRange*eventToChoose + (generator.nextGaussian()*10+normalRange));
            if(statAmount < currentRange)
                break;
        }

        return currentEventList.get(eventToChoose);


    }

    public static Executable generateRandomStatsChange(Professor prof) {
        return randomStatChanges.get(generator.nextInt(randomStatChanges.size()));
    }

    public static Executable generateRandomResourceChange(Professor prof) {
        return randomResourceChanges.get(generator.nextInt(randomResourceChanges.size()));
    }
}
