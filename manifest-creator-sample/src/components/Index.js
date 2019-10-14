import React, { Component, Fragment } from 'react';
import EnvVariable from './EnvVariable';
import Form from './Form';
import RegistrationForm from './RegistrationForm';

class Index extends Component {
    render() {
        return (
            <Fragment>
                <RegistrationForm/>
                <Form />
                <EnvVariable />
                
            </Fragment>
        )
    }
}


export default Index