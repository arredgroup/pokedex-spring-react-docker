package com.arredgroup.pokemonBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonKey;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chain {

    private String id;
    private Evolution chain;

    Chain(){ }

    Chain(String id, Evolution chain){
        this.id = id;
        this.chain = chain;
    }

    public Evolution getChain() {
        return this.chain;
    }

    public String getId() {
        return this.id;
    }
}
