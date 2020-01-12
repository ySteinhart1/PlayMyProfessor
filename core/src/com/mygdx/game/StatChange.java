package com.mygdx.game;
import com.mygdx.game.Professor.Stat;

public class StatChange implements Executable {
    private Stat stat;
    private int value;
    private String popup;

    public StatChange(Professor.Stat stat, int value, String popup) {
        this.stat = stat;
        this.value = value;
        this.popup = popup;
    }

    public StatChange(Professor.Stat stat, int value) {
        this(stat, value, null);
    }

    public void execute(Professor professor) {
        professor.changeStat(stat, value);
        if (popup != null) {
            PlayMyProfessor.getGame().setPopup(popup + " " + stat + " " + value);
        }
    }

    public Stat getStat() {
        return stat;
    }

    public int getValue() {
        return value;
    }

    public String getPopup() { return popup; }
}
