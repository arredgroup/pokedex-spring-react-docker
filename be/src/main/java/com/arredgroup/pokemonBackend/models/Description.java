package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

    private String description;
    private Info language;

    public Description(){ }

    Description(String description, Info language){
        this.description = description;
        this.language = language;
    }

    public String getDescription(){
        return this.description;
    }

    public Info getLanguage() {
        return this.language;
    }
}
