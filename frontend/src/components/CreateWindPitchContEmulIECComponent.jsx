import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService';

class CreateWindPitchContEmulIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kdroop: '',
                kipce: '',
                komegaaero: '',
                kppce: '',
                omegaref: '',
                pimax: '',
                pimin: '',
                t1: '',
                t2: '',
                tpe: ''
        }
        this.changekdroopHandler = this.changekdroopHandler.bind(this);
        this.changekipceHandler = this.changekipceHandler.bind(this);
        this.changekomegaaeroHandler = this.changekomegaaeroHandler.bind(this);
        this.changekppceHandler = this.changekppceHandler.bind(this);
        this.changeomegarefHandler = this.changeomegarefHandler.bind(this);
        this.changepimaxHandler = this.changepimaxHandler.bind(this);
        this.changepiminHandler = this.changepiminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changetpeHandler = this.changetpeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindPitchContEmulIECService.getWindPitchContEmulIECById(this.state.id).then( (res) =>{
                let windPitchContEmulIEC = res.data;
                this.setState({
                    kdroop: windPitchContEmulIEC.kdroop,
                    kipce: windPitchContEmulIEC.kipce,
                    komegaaero: windPitchContEmulIEC.komegaaero,
                    kppce: windPitchContEmulIEC.kppce,
                    omegaref: windPitchContEmulIEC.omegaref,
                    pimax: windPitchContEmulIEC.pimax,
                    pimin: windPitchContEmulIEC.pimin,
                    t1: windPitchContEmulIEC.t1,
                    t2: windPitchContEmulIEC.t2,
                    tpe: windPitchContEmulIEC.tpe
                });
            });
        }        
    }
    saveOrUpdateWindPitchContEmulIEC = (e) => {
        e.preventDefault();
        let windPitchContEmulIEC = {
                windPitchContEmulIECId: this.state.id,
                kdroop: this.state.kdroop,
                kipce: this.state.kipce,
                komegaaero: this.state.komegaaero,
                kppce: this.state.kppce,
                omegaref: this.state.omegaref,
                pimax: this.state.pimax,
                pimin: this.state.pimin,
                t1: this.state.t1,
                t2: this.state.t2,
                tpe: this.state.tpe
            };
        console.log('windPitchContEmulIEC => ' + JSON.stringify(windPitchContEmulIEC));

        // step 5
        if(this.state.id === '_add'){
            windPitchContEmulIEC.windPitchContEmulIECId=''
            WindPitchContEmulIECService.createWindPitchContEmulIEC(windPitchContEmulIEC).then(res =>{
                this.props.history.push('/windPitchContEmulIECs');
            });
        }else{
            WindPitchContEmulIECService.updateWindPitchContEmulIEC(windPitchContEmulIEC).then( res => {
                this.props.history.push('/windPitchContEmulIECs');
            });
        }
    }
    
    changekdroopHandler= (event) => {
        this.setState({kdroop: event.target.value});
    }
    changekipceHandler= (event) => {
        this.setState({kipce: event.target.value});
    }
    changekomegaaeroHandler= (event) => {
        this.setState({komegaaero: event.target.value});
    }
    changekppceHandler= (event) => {
        this.setState({kppce: event.target.value});
    }
    changeomegarefHandler= (event) => {
        this.setState({omegaref: event.target.value});
    }
    changepimaxHandler= (event) => {
        this.setState({pimax: event.target.value});
    }
    changepiminHandler= (event) => {
        this.setState({pimin: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changetpeHandler= (event) => {
        this.setState({tpe: event.target.value});
    }

    cancel(){
        this.props.history.push('/windPitchContEmulIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPitchContEmulIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPitchContEmulIEC</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kdroop: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kipce: </label>
                                            #formFields( $attribute, 'create')
                                            <label> komegaaero: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kppce: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omegaref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpe: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPitchContEmulIEC}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateWindPitchContEmulIECComponent
