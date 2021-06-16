import React, {Component} from 'react';
import { withRouter } from 'react-router-dom';
import PokemonService from "../../services/PokemonService";
import M from "materialize-css";
import Description from "../../components/description/description"
import Evolution from "../../components/evolution/evolution";
import Pokemon from "../../components/pokemon/pokemon";

class Pokedex extends Component {

    constructor(props){
        super(props);
        this.state = {
            pokemon_id: 1
        };
    }

    changeId(new_id){
        if(new_id<1) new_id = 1;
        this.setState({
            pokemon_id: new_id
        });
    }


    render(){
        return (
            <div className="container">
                <h1>Pokedex</h1>
                <div className="card">
                    <div className="card-content">
                        <Pokemon id={this.state.pokemon_id} />
                        <ul className="collapsible">
                            <li>
                                <div className="collapsible-header"><i className="material-icons">filter_drama</i>Descripción
                                </div>
                                <div className="collapsible-body">
                                    <Description id={this.state.pokemon_id} />
                                </div>
                            </li>
                            <li>
                                <div className="collapsible-header"><i className="material-icons">filter_drama</i>Evoluciones
                                </div>
                                <div className="collapsible-body">
                                    <Evolution id={this.state.pokemon_id} />
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div className="card-action">
                        <button className="btn btn-link" onClick={ () => this.changeId(this.state.pokemon_id - 1)}>Anterior</button>
                        <button className="btn btn-link" onClick={ () => this.changeId(this.state.pokemon_id + 1)}>Siguiente</button>
                    </div>
                </div>
            </div>
        );
    }

    componentDidMount() {
        M.AutoInit();
    }
}



export default Pokedex;