package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprite {

    private String front_default;

    Sprite(){}

    Sprite(String front_default){
        this.front_default = front_default;
    }

    public String getFront_default(){
        return this.front_default;
    }
}
