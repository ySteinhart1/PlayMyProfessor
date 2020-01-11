package com.mygdx.game;

import java.util.ArrayList;
import com.mygdx.game.Professor.Stat;

public class Game {

    private Event currentEvent;
    //1 week every 10 seconds
    //1 event per week
    private int timer;
    private int week;
    private ArrayList<Event> possibleEvents;
    private Professor professor;
    private String popup;
    private int popupTimer;


    public Game(Professor professor) {
        week = 1;
        this.professor = professor;
        professor.setResource(Professor.Resource.LAPTOP, 2);
        possibleEvents = new ArrayList<Event>();
        possibleEvents.add(new Event("A student has just cheated on a quiz",
                new Option("Give them a fail in the class", new ResourceCost(Professor.Resource.LAPTOP, 1), "You failed the student and made them cry. Easiness -10", new StatChange(Professor.Stat.EASINESS, -10)),
                new Option("Ignore them, it's too much trouble", "You did the wrong thing. Humor +10", new StatChange(Professor.Stat.HUMOR, 10)),
                new Option("Give them a 0 on the final", new Event("Do you report them for academic dishonesty?",
                    new Option("Yes", "You reported the student", new StatChange(Stat.EASINESS, -10), new StatChange(Stat.ACCESSIBILITY, -10)),
                    new Option("No", "You did not report the student", new StatChange(Stat.EASINESS, 10), new StatChange(Stat.ACCESSIBILITY, 10))))


        ));
    }

    public void render() {
        Graphics.begin();
        professor.drawStats();

        if (popup != null) {
            popupTimer--;
            Graphics.drawWord(popup, 200, 150);
            if (popupTimer == 0) {
                popup = null;
            }
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

    public void setPopup(String popup) {
        this.popup = popup;
        popupTimer = 360;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }
}
