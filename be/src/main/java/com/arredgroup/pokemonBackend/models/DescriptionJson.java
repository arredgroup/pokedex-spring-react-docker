package com.arredgroup.pokemonBackend.models;

public class DescriptionJson {

    private String language;
    private String description;

    public DescriptionJson(){
    }

    public String getDescription() {
        return this.description;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
