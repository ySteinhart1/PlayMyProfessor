package com.mygdx.game;
import com.mygdx.game.Professor.Resource;
public class ResourceChange  implements Executable{
    private Resource resource;
    private int value;

    public ResourceChange(Professor.Resource resource, int value){
        this.resource = resource;
        this.value = value;
    }

    public void execute(Professor professor){
        professor.changeResource(resource, value);
    }

    public Resource getResource(){
        return resource;
    }

    public int getValue(){
        return value;
    }
}
