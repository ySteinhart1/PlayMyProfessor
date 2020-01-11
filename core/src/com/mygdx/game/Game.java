package com.mygdx.game;

import java.util.ArrayList;

public class Game {

    private Event currentEvent;
    //1 week every 10 seconds
    //1 event per week
    private int timer;
    private int week;
    private ArrayList<Event> possibleEvents;
    private Professor professor;

    public Game(Professor professor) {
        week = 1;
        this.professor = professor;
        possibleEvents = new ArrayList<Event>();
        possibleEvents.add(new Event("A student has just cheated on a quiz",
                new Option("Give them a fail in the class", new StatChange(Professor.Stat.EASINESS, -10)),
                new Option("Give them a 0 on the quiz", new StatChange(Professor.Stat.EASINESS, -10)),
                new Option("Ignore them, it's too much trouble", new StatChange(Professor.Stat.HUMOR, 10))));
    }

    public void render() {
        Graphics.begin();
        for (int i = 0; i < Professor.Stat.values().length; i++) {
            Professor.Stat stat = Professor.Stat.values()[i];
            Graphics.resize(.75f);
            Graphics.drawWord(stat.name() + ": " +  professor.getStat(stat), 1000, 700 - i*50);
            Graphics.resize(1);
        }
        Graphics.end();



        if (currentEvent == null) {
            timer++;
        } else {
            currentEvent.drawEvent(professor);
        }
        if (timer % 3 == 0 && currentEvent == null) {
            //week end

            if (!possibleEvents.isEmpty()) {
                int i = (int) (Math.random() * possibleEvents.size());
                currentEvent = possibleEvents.get(i);
                possibleEvents.remove(i);
            }

            week++;
        }




    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }
}
