import React, {Component} from 'react';
import PokemonService from "../../services/PokemonService";

class Description extends Component {

    constructor(props) {
        super(props);
        this.state = {
            id: props.id,
            descriptions: [],
            loading: true
        };
    }

    componentDidMount() {
        this.getDescription(this.state.id);
    }

    componentWillReceiveProps(nextProps) {
        this.setState({ id: nextProps.id });
        this.getDescription(nextProps.id);
    }

    async getDescription(id){
        this.setState({
            loading: true
        });
        if(id<1) id = 1;
        const description = await PokemonService.getDescriptionsById(id);
        this.setState({
            descriptions: description.data,
            loading: false
        });

    }

    render(){
        return (
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>Lenguaje</th>
                            <th>Descripción</th>
                        </tr>
                    </thead>
                    <tbody>
                    { this.state.descriptions.map((element, i) => {
                        return (<tr key={i}>
                            <td>{element.language}</td>
                            <td>{element.description}</td>
                        </tr>)
                    }
                    )}
                    </tbody>
                </table>
                { (this.state.loading)? <div className="progress"><div className="indeterminate"></div></div> : null}
            </div>
        )
    }

}

export default Description;