package com.mygdx.game;
import com.mygdx.game.Professor.Stat;

public class StatChange implements Executable {
    private Stat stat;
    private int value;

    public StatChange(Professor.Stat stat, int value) {
        this.stat = stat;
        this.value = value;
    }

    public void execute(Professor professor) {
        professor.changeStat(stat, value);
    }

    public Stat getStat() {
        return stat;
    }

    public int getValue() {
        return value;
    }
}
