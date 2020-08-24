import React from 'react'
import Person from './person'

const PersonList = (props) => {
    const persons = props.persons.map((person) => {
        return(
            <Person key={person.id} person={person}/>
        )
    });
    return(
        <div>{persons}</div>
    )
}

export default PersonList;
