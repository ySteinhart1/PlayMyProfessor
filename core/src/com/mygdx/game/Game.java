package com.mygdx.game;

import java.text.DecimalFormat;
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
    private Professor professor;
    private String popup;
    private int popupTimer;
    private Texture head;
    private boolean gameOver;


    public Game(Professor professor) {
        week = 1;
        this.professor = professor;
        professor.setResource(Professor.Resource.LAPTOP, 1);
        professor.setResource(Professor.Resource.TA, 2);
        professor.setResource(Professor.Resource.CHALK, 2);
        professor.setResource(Professor.Resource.YERBA, 1);
        head = new Texture("head" + ((int)(Math.random()*4) + 1) + ".png");
    }

    public void render() {
        //professor stats
        Graphics.begin();
        professor.drawStats();
        //popup
        if (popup != null) {
            popupTimer--;
            Graphics.drawWord(popup, 100, 250);
            if (popupTimer == 0) {
                popup = null;
            }
        }
        Graphics.end();

        //tick timer
        if (currentEvent == null && popup == null && !gameOver) {
            timer++;
        } else if (currentEvent != null && !gameOver){
            currentEvent.drawEvent(professor);
        }
        if (timer % 150 == 0 && timer % 300 != 0 && Math.random() < .5 && currentEvent == null) {
            //event halfway through week
            doEvent();
        }
        if (timer % 300 == 0 && currentEvent == null) {
            //week end
            week++;
            if (week == 11) {
                gameOver = true;
            } else {
                doEvent();
            }
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


        //end game
        if (gameOver) {
            Graphics.begin();
            Graphics.drawWord("Rating: " + new DecimalFormat("#.#").format(professor.get_RMP()), 500, 400);
            Graphics.end();
        }



    }

    public void doEvent() {
        if (Math.random() < .5) {
            currentEvent = EventGenerator.generateEvent(professor);
        } else if (Math.random() < .5) {
            EventGenerator.generateRandomResourceChange(professor).execute(professor);
        } else {
            EventGenerator.generateRandomStatsChange(professor).execute(professor);
        }
        timer++;
    }

    public void setPopup(String popup) {
        if (popup != null) {
            this.popup = popup;
            popupTimer = 240;
        }
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }
}
