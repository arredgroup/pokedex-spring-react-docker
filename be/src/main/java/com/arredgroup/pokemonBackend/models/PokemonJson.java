package com.arredgroup.pokemonBackend.models;

import java.util.ArrayList;
import java.util.List;

public class PokemonJson {

    private int id;
    private String name;
    private String image;
    private String weight;
    private List<String> types;
    private List<String> abilities;


    public PokemonJson(){
        this.types = new ArrayList<String>();
        this.abilities = new ArrayList<String>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
    }

    public String getWeight() {
        return this.weight;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public List<String> getAbilities() {
        return this.abilities;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void addType(String type){
        this.types.add(type);
    }

    public void addAbility(String ability){
        this.abilities.add(ability);
    }
}