import React, { Component } from 'react';
import { Paper } from '@material-ui/core';
import '../css/RegistrationForm.css';

class RegistrationForm extends Component {
    onsubmit(event) {
        console.log("form submitted");
        event.preventdefault();
    }
    render() {
        return (
            <Paper className="paper">
                <h3>Registration Form</h3>
                <hr />
                <form>
                    <label>Name</label> <input type="text" /><br />
                    <label>Email</label> <input type="text" /><br />
                    <label>Gender</label>
                    <input type="radio" name="gender" value="male" /> <label>male</label>
                    <input type="radio" name="gender" value="female" /> <label>Female</label>
                    <input type="submit" value="submit" onSubmit={(e) => this.onsubmit(e)} />
                </form>
            </Paper>
        )
    }
}

export default RegistrationForm