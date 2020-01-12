package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
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
        PlayMyProfessor.getGame().setCurrentEvent(null);
        PlayMyProfessor.getGame().setPopup(options[index].getPopup());
        for(Executable e : options[index].getExecutables()) {
            e.execute(professor);
        }

        if (options[index].getResourceCost() != null) {
            professor.changeResource(options[index].getResourceCost().getResource(), -options[index].getResourceCost().getValue());
        }
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

            if (options[i].checkResources(professor) && Graphics.xIsBetween(200, 1200) && Graphics.yIsBetween(400 - (i+1)*50, 400 - i*50)) {
                Graphics.getShapeRenderer().setColor(new Color(.25f, .25f, .5f, 1));
                Graphics.getShapeRenderer().rect(200, 400 - (i + 1) * 50, 1040, 50);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    chooseOption(professor, i);
                }
            }
        }
        Graphics.getShapeRenderer().end();

        Graphics.begin();
        Graphics.drawWord(message, 200 + 9, 500 - 9);
        for (int i = 0; i < options.length; i++) {
            Graphics.drawWord(options[i].getMessage() + (options[i].getResourceCost() == null ? "" : " (costs " + options[i].getResourceCost().getValue() + " " + options[i].getResourceCost().getResource() + ")"), 200 + 9, 400 - 9 - i*50);
        }
        Graphics.end();

        Gdx.gl.glEnable(GL30.GL_BLEND);
        Graphics.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < options.length; i++) {
            if (!options[i].checkResources(professor)) {
                Graphics.getShapeRenderer().setColor(new Color(0f, 0f, 0f, .3f));
                Graphics.getShapeRenderer().rect(200, 400 - (i + 1) * 50, 1040, 50);
            }
        }
        Graphics.getShapeRenderer().end();
        Gdx.gl.glDisable(GL30.GL_BLEND);



    }
}
