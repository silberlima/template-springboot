package com.template.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.dto.PersonDTO;

@RestController
@RequestMapping("/person")
public interface PersonController {
    
    @GetMapping("/{id}")
    ResponseEntity<PersonDTO> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<PersonDTO>> findAll();

    @PostMapping
    ResponseEntity<PersonDTO> save(@RequestBody PersonDTO person);

    @PutMapping("/{id}")
    ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<PersonDTO> delete(@PathVariable Long id);
}
