package com.mygdx.game;
import com.mygdx.game.Professor.Resource;
public class ResourceChange  implements Executable{
    private Resource resource;
    private int value;
    private String popup;

    public ResourceChange(Professor.Resource resource, int value, String popup){
        this.resource = resource;
        this.value = value;
        this.popup = popup;
    }

    public ResourceChange(Professor.Resource resource, int value){
       this(resource, value, null);
    }

    public void execute(Professor professor){
        professor.changeResource(resource, value);
        if (popup != null) {
            PlayMyProfessor.getGame().setPopup(popup + " " + resource + " " + getValueString());
        }
    }

    public Resource getResource(){
        return resource;
    }

    public int getValue(){
        return value;
    }

    public String getValueString() {
        return value <= 0 ? ("" + value) : ("+" + value);
    }

    public String getPopup() { return popup; }
}
