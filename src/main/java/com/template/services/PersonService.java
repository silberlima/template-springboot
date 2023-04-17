package com.template.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.stereotype.Service;

import com.template.dto.PersonDTO;

@Service
public interface PersonService {

    PersonDTO findById(Long id);

    List<PersonDTO> findAll();

    PersonDTO save(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO, Long id);

    void deleteById(Long id);

}
