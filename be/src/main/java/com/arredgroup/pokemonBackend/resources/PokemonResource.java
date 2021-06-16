package com.arredgroup.pokemonBackend.resources;

import com.arredgroup.pokemonBackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/pokemon")
public class PokemonResource {

    @RequestMapping("{id}/info")
    public PokemonJson getPokemon(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        ArrayList<String> data = new ArrayList<String>();
        Pokemon p;
        if(id.matches("-?\\d+")) {
            Chain c = restTemplate.getForObject("https://pokeapi.co/api/v2/evolution-chain/" + id, Chain.class);
            p = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + c.getChain().getSpecies().getName(), Pokemon.class);
            assert p != null;
        }
        else
            p = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + id, Pokemon.class);
        PokemonJson pokemon = new PokemonJson();
        pokemon.setId(p.getId());
        pokemon.setName(p.getName());
        pokemon.setWeight(p.getWeight());
        pokemon.setImage(p.getSprites().getFront_default());

        for(int i=0;i<p.getAbilities().size();i+=1){
            pokemon.addAbility(p.getAbilities().get(i).getAbility().getName());
        }
        for(int i=0;i<p.getTypes().size();i+=1){
            pokemon.addType(p.getTypes().get(i).getType().getName());
        }
        return pokemon;
    }

    @RequestMapping("/{id}/evolutions")
    public EvolutionJson getEvolutions(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();
        Chain p = restTemplate.getForObject("https://pokeapi.co/api/v2/evolution-chain/" + id, Chain.class);
        EvolutionJson evolutions = new EvolutionJson();
        assert p != null;
        Evolution evo = p.getChain();
        while(evo!=null){
            evolutions.addPokemon(evo.getSpecies().getName());
            if(!evo.getEvolves_to().isEmpty())
                evo = evo.getEvolves_to().get(0);
            else
                evo = null;
        }
        return evolutions;
    }

    @RequestMapping("/{id}/descriptions")
    public ArrayList<DescriptionJson> getDescriptions(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();
        PokemonDescription p = restTemplate.getForObject("https://pokeapi.co/api/v2/characteristic/" + id, PokemonDescription.class);
        ArrayList<DescriptionJson> descriptions = new ArrayList<DescriptionJson>();
        assert p != null;
        for(int i=0;i<p.getDescriptions().size();i+=1){
            DescriptionJson d = new DescriptionJson();
            d.setDescription(p.getDescriptions().get(i).getDescription());
            d.setLanguage(p.getDescriptions().get(i).getLanguage().getName());
            descriptions.add(d);
        }
        return descriptions;
    }

    @RequestMapping("/{id}/")
    public ArrayList<String> getInfo(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();

        ArrayList<String> data = new ArrayList<String>();
        Chain c = restTemplate.getForObject("https://pokeapi.co/api/v2/evolution-chain/" + id, Chain.class);
        assert c != null;
        data.add(c.getChain().getSpecies().getName());

        Pokemon p = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + c.getChain().getSpecies().getName(), Pokemon.class);
        assert p != null;
        data.add(String.valueOf(p.getId()));

        return data;
    }


}
