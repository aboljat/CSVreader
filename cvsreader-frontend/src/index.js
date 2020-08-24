import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import PersonList from './component/person_list'
import UploadService from './component/UploadService'
import './css/styles.module.css'

class App extends Component {

state = {
    persons:[]
}

refreshPersons = () => {
    fetch('csvapp/getPersons')
    .then(res => res.json())
    .then((data) => {
      console.log('This is your data', data);
      this.setState({ persons: data })
    })
    .catch(console.log)
}

componentDidMount() {
    this.refreshPersons();
}

render() {
    return(
        <div>
            <h1>Aplikacija za upload csv datoteke sa popisom osoba</h1>
            <UploadService refreshPersons={this.refreshPersons}/>
            <h2>Popis osoba:</h2>
            <PersonList persons={this.state.persons}/>
        </div>
      )
  }
}
ReactDOM.render(<App/>, document.querySelector('#root'));

