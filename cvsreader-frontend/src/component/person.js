import React from 'react'
import '../css/styles.module.css'


const Person = ({person}) => {

    return(
        
        <div className="person">
            <div>Ime: {person.name}</div>
            <div>Prezime: {person.surname}</div>
            <div>Datum Rođenja: {person.dateOfBirth}</div>
        </div>
    )
}

export default Person;