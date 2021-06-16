package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDescription {

    private List<Description> descriptions;

    PokemonDescription(){ }

    PokemonDescription(List<Description> descriptions){
        this.descriptions = descriptions;
    }

    public List<Description> getDescriptions(){
        return this.descriptions;
    }

}
