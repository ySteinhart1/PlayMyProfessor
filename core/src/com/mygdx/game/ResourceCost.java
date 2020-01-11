package com.mygdx.game;
import com.mygdx.game.Professor.Resource;

public class ResourceCost {
    private Resource resource;
    private int value;

    public ResourceCost(Professor.Resource resource, int value){
        this.resource = resource;
        this.value = value;
    }

    public Resource getResource(){
        return resource;
    }

    public int getValue(){
        return value;
    }

}
