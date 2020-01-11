package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Professor;
import com.mygdx.game.Professor.Stat;

public class Event implements Executable {
    private String message;
    private Option[] options;

    public Event(String message, Option... options) {
       this.options = options;
       this.message = message;
    }

    public void chooseOption(Professor professor, int index) {
        for(Executable e : options[index].getExecutables()) {
            e.execute(professor);
        }
        PlayMyProfessor.getGame().setCurrentEvent(null);
    }

    public void execute(Professor prof) {
        //sets current event to this
        PlayMyProfessor.getGame().setCurrentEvent(this);
    }

    public void drawEvent(Professor professor) {
        Graphics.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < options.length; i++) {
            Graphics.getShapeRenderer().setColor(new Color(.75f, .75f, 1, 1));
            Graphics.getShapeRenderer().rect(200, 400 - (i+1)*50, 1040, 50);

            if (Graphics.xIsBetween(200, 1200) && Graphics.yIsBetween(400 - (i+1)*50, 400 - i*50)) {
                Graphics.getShapeRenderer().setColor(new Color(.25f, .25f, .5f, 1));
                Graphics.getShapeRenderer().rect(200, 400 - (i + 1) * 50, 1040, 50);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    chooseOption(professor, i);
                }
            }
        }
        Graphics.getShapeRenderer().end();

        Graphics.begin();
        Graphics.drawWord(message, 200, 500);
        for (int i = 0; i < options.length; i++) {
            Graphics.drawWord(options[i].getMessage(), 200, 400 - i*50);
        }
        Graphics.end();

    }
}
