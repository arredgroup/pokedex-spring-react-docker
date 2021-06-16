package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {

    private int slot;
    private Info type;

    Type(){}

    Type(int slot, Info type){
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public Info getType() {
        return type;
    }
}
