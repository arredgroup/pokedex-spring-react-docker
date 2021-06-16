import React, {Component} from 'react';
import PokemonService from "../../services/PokemonService";
import Pokemon from "../pokemon/pokemon";
import M from "materialize-css";

class Evolution extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: props.id,
            descriptions: [],
            loading: true,
        };
    }

    componentDidMount() {
        M.AutoInit();
        this.getEvolutions(this.state.id);
    }

    componentWillReceiveProps(nextProps) {
        this.setState({ id: nextProps.id });
        this.getEvolutions(nextProps.id);
    }

    async getEvolutions(id){
        this.setState({
            loading: true
        });
        if(id<1) id = 1;
        const evolution = await PokemonService.getEvolutionsById(id);
        this.setState({
            descriptions: evolution.data.pokemons,
            loading: false
        });
        M.AutoInit();

    }


    render(){
        return(
            <div className="row">
                <div className="col s12">
                    { this.state.descriptions.map((element, i) =>{
                        return <Pokemon id={element} />
                    })}
                </div>
            </div>
        )
    }

}

export default Evolution;