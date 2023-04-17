package com.template.factory;

import com.template.dto.PersonDTO;
import com.template.model.Person;

public class PersonFactory {
    
    public static PersonDTO entityToDTO(Person person){
        return new PersonDTO(person.getId(), person.getName(), person.getAddress(), person.getGender());
    }

    public static Person dtoToEntity(PersonDTO personDTO){
        return new Person(personDTO.id(), personDTO.name(), personDTO.address(), personDTO.gender());
    }

    public static Person dtoToEntity(PersonDTO personDTO, Long id){
        return new Person(id, personDTO.name(), personDTO.address(), personDTO.gender());
    }

    public static Person entiryToEntity(Person person, Long id){
        return new Person(id, person.getName(), person.getAddress(), person.getGender());
    }
}
