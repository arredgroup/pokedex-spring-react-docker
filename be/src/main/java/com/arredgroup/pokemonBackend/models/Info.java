package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private String name;
    private String url;

    Info(){}

    Info(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String getName(){
        return this.name;
    }

    public String getUrl(){
        return this.url;
    }
}
