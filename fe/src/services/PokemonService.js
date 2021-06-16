import http from './http-services';

class PokemonService {

    getById(id){
       return http.get('/' + id + "/info");
    }

    getEvolutionsById(id){
        return http.post("/" + id + "/evolutions");
    }

    getDescriptionsById(id){
        return http.post("/" + id + "/descriptions");
    }
}

export default new PokemonService();