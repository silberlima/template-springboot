package com.template.controller.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.template.controller.PersonController;
import com.template.dto.PersonDTO;
import com.template.services.PersonService;

@Service
public class PersonControllerImp implements PersonController {

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<PersonDTO> findById(Long id) {
        try {
            return ResponseEntity.ok(personService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<List<PersonDTO>> findAll(){
        try {
            return ResponseEntity.ok(personService.findAll());            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<PersonDTO> save(PersonDTO person) {
        try {
            return ResponseEntity.ok(personService.save(person));            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<PersonDTO> update(PersonDTO personDTO, Long id) {
        try {
            return ResponseEntity.ok(personService.update(personDTO,id));            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Override
    public ResponseEntity<PersonDTO> delete(Long id) {
        try {
            personService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);          
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
