import React, { Component, Fragment } from 'react';
//import { Paper } from '@material-ui/core';
import index from 'json2yaml';
import '../css/Form.css';

class Form extends Component {

    constructor() {
        super();
        this.state = {
            name: null,
            email: null,
            age: null,
            description: null
        }
        this.handleInput=this.handleInput.bind(this);
        this.handleSubmit=this.handleSubmit.bind(this);
    }

    handleDownload(){
        const element = document.createElement("a");
        const file = new Blob([this.state.description], {type: 'text/plain'});
        element.href = URL.createObjectURL(file);
        element.download = "manifest.yml";
        document.body.appendChild(element); // Required for this to work in FireFox
        element.click();
    }

    handleSubmit(event) {
        let details={
            name: null,
            email: null,
            age: null
        }
       
        console.log("Form submitted");

        details.name=this.state.name;
        details.email=this.state.email;
        details.age=this.state.age;

        let detail=JSON.parse(JSON.stringify(details));
        console.log(detail);
        console.log(index.stringify(detail));
        this.setState({
            description: index.stringify(detail)
        })        
        event.preventDefault();
        
    }
    handleInput(event){
        this.setState({
            [event.target.name]:event.target.value
        })
    }
    render() {
      
        return (
          <Fragment>
                <div>
                Name: <input type="text" name="name" onChange={e=>this.handleInput(e)}/>
                Email: <input type="email" name="email" onChange={e=>this.handleInput(e)}/>
                Age: <input type="number" name="age" onChange={e=>this.handleInput(e)} />
                <input type="submit" value="submit" onClick={(e) => this.handleSubmit(e)} />
                
            </div>
            <div className="card"><pre style={{"fontSize":"20px"}}>{this.state.description}</pre></div>
            <button onClick={this.handleDownload}>Download</button>
            
          </Fragment>
        )
    }
}
export default Form