package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evolution {

    private Info species;
    private List<Evolution> evolves_to;

    Evolution(){}

    Evolution(Info species, List<Evolution> evolves_to){
        this.species = species;
        this.evolves_to = evolves_to;
    }

    public Info getSpecies(){
        return this.species;
    }

    public List<Evolution> getEvolves_to(){
        return this.evolves_to;
    }

}
