package com.arredgroup.pokemonBackend.models;

import java.util.ArrayList;

public class EvolutionJson {

    ArrayList<String> pokemons;

    public EvolutionJson(){
        this.pokemons = new ArrayList<String>();
    }

    public ArrayList<String> getPokemons() {
        return pokemons;
    }

    public void addPokemon(String pokemon){
        this.pokemons.add(pokemon);
    }
}
