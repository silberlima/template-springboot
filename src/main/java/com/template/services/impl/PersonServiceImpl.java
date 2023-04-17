package com.template.services.impl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.dto.PersonDTO;
import com.template.factory.PersonFactory;
import com.template.repository.PersonRepository;
import com.template.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO findById(Long id) {
        logger.info("Find Person by Id");
        return PersonFactory.entityToDTO(personRepository.findById(id).orElse(null));
    }

    public List<PersonDTO> findAll() {
        logger.info("Find All Persons");
        return personRepository.findAll()
                .stream()
                .map(person -> PersonFactory.entityToDTO(person))
                .collect(Collectors.toList());
    }

    public PersonDTO save(PersonDTO personDTO) {
        logger.info("Save new person");

        return PersonFactory.entityToDTO(personRepository.save(PersonFactory.dtoToEntity(personDTO)));
    }

    public PersonDTO update(PersonDTO personDTO, Long id) {
        logger.info("Update person: " + id);
        return PersonFactory.entityToDTO(personRepository.save(PersonFactory.dtoToEntity(personDTO,id)));
    }

    public void deleteById(Long id) {
        logger.info("Delete person: " + id);
        personRepository.deleteById(id);
    }

}
