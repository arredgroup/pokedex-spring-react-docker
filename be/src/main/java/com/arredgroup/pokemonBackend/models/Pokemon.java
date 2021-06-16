package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    private int id;
    private String name;
    private Sprite sprites;
    private List<Type> types;
    private String weight;
    private List<Abilities> abilities;
    private String height;

    public Pokemon(){}

    public Pokemon(int id, String name, Sprite sprites, List<Type> types, String weight, List<Abilities> abilities, String height){
        this.id = id;
        this.name = name;
        this.sprites = sprites;
        this.types = types;
        this.weight = weight;
        this.abilities = abilities;
        this.height = height;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Sprite getSprites(){
        return this.sprites;
    }

    public List<Type> getTypes(){
        return this.types;
    }

    public String getWeight(){
        return this.weight;
    }

    public List<Abilities> getAbilities(){
        return this.abilities;
    }

    public String getHeight(){
        return this.height;
    }

    @Override
    public String toString(){
        return "";
    }

}
