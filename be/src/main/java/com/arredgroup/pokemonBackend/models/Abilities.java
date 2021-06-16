package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {
    private String is_hidden;
    private String slot;
    private Info ability;

    Abilities(){}

    Abilities(String is_hidden, String slot, Info ability){
        this.is_hidden = is_hidden;
        this.slot = slot;
        this.ability = ability;
    }

    public String getIs_hidden(){
        return this.is_hidden;
    }

    public String getSlot(){
        return this.slot;
    }

    public Info getAbility(){
        return this.ability;
    }
}
