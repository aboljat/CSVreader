import React, { Component } from 'react';
import axios from 'axios';
import '../css/styles.module.css'

class UploadService extends Component {

  state = {
    title: '',
    content: '',
    file: null
  };

  handleChange = (event) => {
    this.setState({
      [event.target.id]: event.target.value
    })
  };

  handleFileChange = (event) => {
    this.setState({
      file: event.target.files[0]
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state);
    let form_data = new FormData();
    form_data.append('file', this.state.file);
    let url = 'csvapp/insert/';
    axios.post(url, form_data, {
      headers: {
        'content-type': 'multipart/form-data'
      }
    })
        .then(res => {
          console.log(res.data);
          this.props.refreshPersons();
        })
        .catch(err => console.log(err))
  };


  render() {
    return (
        <form onSubmit={this.handleSubmit}>
          <p>
            <input type="file"
                   id="file"
                   accept="file/csv"  onChange={this.handleFileChange} required/>
          </p>
          <input type="submit"/>
        </form>
    );
  }
  
}
export default UploadService;