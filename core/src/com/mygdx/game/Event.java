package com.mygdx.game;
import com.mygdx.game.Professor;
import com.mygdx.game.Professor.Stat;

public class Event implements Executable {
    private String message;
    private Option[] options;
    private Option optionChoice;


    public Event(String message, Option... options) {
       this.options = options;
       this.message = message;
    }

    public void chooseOption(Professor professor, int index) {
        for(Executable e : options[index].getExecutables()) {
            e.execute(professor);
        }
    }

    public void execute(Professor prof) {
        //sets current event to this
    }
}
