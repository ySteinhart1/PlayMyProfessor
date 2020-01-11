package com.mygdx.game;
import com.mygdx.game.Professor.Stat;

/**
 * Lists the option for each event
 */
public class Option {

    private String message;
    private Executable[] executables;
    private Event event;
    private ResourceCost resourceCost;
    private String popup;

    public Option(String message, ResourceCost resourceCost, String popup, Executable... executables) {
        this.message = message;
        this.resourceCost = resourceCost;
        this.executables = executables;
    }

    public Option(String message, ResourceCost resourceCost, Executable... executables) {
        this(message, resourceCost, null, executables);
    }

    public Option(String message, String popup, Executable... executables) {
        this(message, null, popup, executables);
    }

    public Option(String message, Executable... executables) {
        this(message, null, null, executables);
    }

    public boolean checkResources(Professor professor) {
        if (resourceCost == null) {
            return true;
        }
        return professor.getResource(resourceCost.getResource()) >= resourceCost.getValue();
    }

    public Executable[] getExecutables() {
        return executables;
    }
    public String getMessage() {
        return message;
    }

    public ResourceCost getResourceCost() {
        return resourceCost;
    }

    public String getPopup() {
        return popup;
    }

}
