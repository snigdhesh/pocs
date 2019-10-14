import React, { Component } from 'react';
import { Paper, TextField,  Button} from '@material-ui/core';
import '../css/EnvVariable.css';

class EnvVariable extends Component {
    addRow(){
        console.log("added new row");
    }
    render() {
        const styles = {
            paper: {
                "border": "1px solid black",
                "margin": "2%",
                "padding": "1%"
            },
            textfield: {
                "margin": "2%"
            },
            button:{
                "marginTop":"2%",
                "marginLeft":"1%"
            }
        }

        return (
            <Paper className="paper">
                <h3>Environment Variables</h3>

                <form>
                
                    <TextField
                        style={styles.textfield}
                        id="name"
                        label="Name"
                        margin="normal"
                    />
                    <TextField
                        style={styles.textfield}
                        id="value"
                        label="Value"
                        margin="normal"
                    />
                    <Button style={styles.button} variant="outlined" color="primary" onClick={this.addRow}>Add</Button>
                    <Button style={styles.button} variant="outlined">Delete</Button>
                
                </form>
            </Paper>
        )
    }
}

export default EnvVariable