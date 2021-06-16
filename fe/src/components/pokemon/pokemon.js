import React, {Component} from 'react';
import PokemonService from "../../services/PokemonService";

class Pokemon extends Component {

    constructor(props){
        super(props);
        this.state = {
            id: props.id,
            name: "Cargando...",
            types: "Cargando...",
            weight: "Cargando...",
            image: "#",
            abilities: [],
            loading: true,
        };
    }

    componentDidMount() {
        this.getPokemon(this.state.id);
    }

    componentWillReceiveProps(nextProps) {
        this.setState({ id: nextProps.id });
        this.getPokemon(nextProps.id);
    }

    async getPokemon(id) {
        this.setState({
            loading: true
        })
        if(id<1) id = 1;
        const pokemon = await PokemonService.getById(id);
        this.setState({
            name: pokemon.data.name,
            image: pokemon.data.image,
            types: pokemon.data.types.map((type,i)=>{ return (<a className="btn btn-small disabled" style={{ marginLeft: 5 +"px" }}>{type}</a>) }),
            weight: pokemon.data.weight,
            abilities: pokemon.data.abilities.map((ability,i)=>{ return (<a className="btn btn-small disabled" style={{ marginLeft: 5 +"px" }}>{ability}</a>)}),
            loading: false
        })
    }

    render(){
        return (
            <div className="row">
                <div className="col s2">
                    <img src={this.state.image} alt=""/>
                </div>
                <div className="col s10">
                    <span className="card-title">Nombre: <b>{this.state.name}</b></span>
                    Tipo: {this.state.types } <br /><br />
                    Peso: <a className="btn btn-small disabled" style={{ marginLeft: 5 +"px" }}>{this.state.weight}</a> <br /><br />
                    Habilidades: {this.state.abilities}<br />
                </div>
                { (this.state.loading)? <div className="progress"><div className="indeterminate"></div></div> : null}
            </div>
        )
    }

}

export default Pokemon;