package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Professor.Stat;

public class Game {

    private Event currentEvent;
    //1 week every 10 seconds
    //1 event per week
    private int timer;
    private int week;
//    private ArrayList<Event> possibleEvents;
    private Professor professor;
    private String popup;
    private int popupTimer;
    private Texture head;


    public Game(Professor professor) {
        week = 1;
        this.professor = professor;
        professor.setResource(Professor.Resource.LAPTOP, 1);
        professor.setResource(Professor.Resource.TA, 2);
        professor.setResource(Professor.Resource.CHALK, 2);
        professor.setResource(Professor.Resource.YERBA, 1);
//        possibleEvents = new ArrayList<Event>();
//        possibleEvents.add(new Event("A student has just cheated on a quiz",
//                new Option("Give them a fail in the class", new ResourceCost(Professor.Resource.LAPTOP, 1), "You failed the student and made them cry. Easiness -10", new StatChange(Professor.Stat.EASINESS, -10)),
//                new Option("Ignore them, it's too much trouble", "You did the wrong thing. Humor +10", new StatChange(Professor.Stat.HUMOR, 10)),
//                new Option("Give them a 0 on the final", new Event("Do you report them for academic dishonesty?",
//                    new Option("Yes", "You reported the student", new StatChange(Stat.EASINESS, -10), new StatChange(Stat.ACCESSIBILITY, -10)),
//                    new Option("No", "You did not report the student", new StatChange(Stat.EASINESS, 10), new StatChange(Stat.ACCESSIBILITY, 10))))
//
//        ));


        head = new Texture("head" + ((int)(Math.random()*4) + 1) + ".png");
    }

    public void render() {
        //professor stats
        Graphics.begin();
        professor.drawStats();
        //popup
        if (popup != null) {
            popupTimer--;
            Graphics.drawWord(popup, 200, 150);
            if (popupTimer == 0) {
                popup = null;
            }
        }
        Graphics.end();

        //tick timer
        if (currentEvent == null) {
            timer++;
        } else {
            currentEvent.drawEvent(professor);
        }
        if (timer % 150 == 0 && timer % 300 != 0 && Math.random() < .5 && currentEvent == null) {
            //event halfway through week
            doEvent();
        }
        if (timer % 300 == 0 && currentEvent == null) {
            //week end
            doEvent();
//            if (!possibleEvents.isEmpty()) {
//                int i = (int) (Math.random() * possibleEvents.size());
//                currentEvent = possibleEvents.get(i);
//                possibleEvents.remove(i);
//            }
            week++;
        }

        //progress bar
        Graphics.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        Graphics.getShapeRenderer().setColor(Color.WHITE);
        Graphics.getShapeRenderer().rect(100, 100, 1240, 5);
        for (int i = 0; i < 11; i++) {
            Graphics.getShapeRenderer().circle(1240/10*i + 100, 100, 10);
        }
        Graphics.getShapeRenderer().end();


        Graphics.begin();
        for (int i = 0; i < 10; i++) {
            Graphics.drawWord("" + (i + 1), 1240/10*i + 100, 80);
        }
        Graphics.drawWord("End", 1340, 80);
        Graphics.draw(head, 100 + 1240/10 * timer/300 - head.getWidth()/2, 110);
        Graphics.end();



    }

    public void doEvent() {
        if (Math.random() < .33) {
            currentEvent = EventGenerator.generateEvent(professor);
        } else if (Math.random() < .66) {
            EventGenerator.generateRandomResourceChange(professor).execute(professor);
        } else {
            EventGenerator.generateRandomStatsChange(professor).execute(professor);
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
