package com.mygdx.game;
import com.mygdx.game.Professor.Stat;

/**
 * Lists the option for each event
 */
public class Option {

    private String message;
    private Executable[] executables;
    private Event event;

    public Option(String message, Executable... executables) {
        this.message = message;
        this.executables = executables;
    }

    public Executable[] getExecutables() {
        return executables;
    }
    public String getMessage() {
        return message;
    }

}
