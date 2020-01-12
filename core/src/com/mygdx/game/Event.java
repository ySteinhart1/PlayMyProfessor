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

        for(Executable e : options[index].getExecutables()) {
            e.execute(professor);
        }

        String popup = "";
        if (options[index].getPopup() != null) {
            popup += options[index].getPopup();
        }
        for (Executable e : options[index].getExecutables()) {
            if (e instanceof StatChange) {
                popup += " " + ((StatChange)e).getStat() + " " + ((StatChange)e).getValue();
            }
            if (e instanceof ResourceChange) {
                popup += " " + ((ResourceChange)e).getResource() + " " + ((ResourceChange)e).getValue();
            }
        }
        PlayMyProfessor.getGame().setPopup(popup);

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
            Graphics.getShapeRenderer().setColor(new Color(.5f, .5f, 1, 1));
            Graphics.getShapeRenderer().rect(100, 400 - (i+1)*50, 1240, 50);

            if (options[i].checkResources(professor) && Graphics.xIsBetween(100, 1340) && Graphics.yIsBetween(400 - (i+1)*50, 400 - i*50)) {
                Graphics.getShapeRenderer().setColor(new Color(.25f, .25f, .5f, 1));
                Graphics.getShapeRenderer().rect(100, 400 - (i + 1) * 50, 1240, 50);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    chooseOption(professor, i);
                }
            }
        }
        Graphics.getShapeRenderer().end();

        Graphics.begin();
        Graphics.drawWord(message, 100 + 9, 500 - 9);
        for (int i = 0; i < options.length; i++) {
            Graphics.drawWord(options[i].getMessage() + (options[i].getResourceCost() == null ? "" : " (costs " + options[i].getResourceCost().getValue() + " " + options[i].getResourceCost().getResource() + ")"), 100 + 9, 400 - 9 - i*50);
        }
        Graphics.end();

        Gdx.gl.glEnable(GL30.GL_BLEND);
        Graphics.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < options.length; i++) {
            if (!options[i].checkResources(professor)) {
                Graphics.getShapeRenderer().setColor(new Color(0f, 0f, 0f, .3f));
                Graphics.getShapeRenderer().rect(100, 400 - (i + 1) * 50, 1240, 50);
            }
        }
        Graphics.getShapeRenderer().end();
        Gdx.gl.glDisable(GL30.GL_BLEND);



    }
}
