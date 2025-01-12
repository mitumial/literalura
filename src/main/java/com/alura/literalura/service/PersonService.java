package com.alura.literalura.service;

import com.alura.literalura.dto.PersonDTO;
import com.alura.literalura.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<PersonDTO> findAll(){
        return repository.findAll().stream()
                .map(p -> new PersonDTO(p.getName(), p.getBirthyear(), p.getDeathyear()))
                .collect(Collectors.toList());
    }

    public List<PersonDTO> findByDeathYear(Integer year) {
        return repository.findByDeathyearGreaterThanEqual(year).stream()
                .map(p -> new PersonDTO(p.getName(), p.getBirthyear(), p.getDeathyear()))
                .collect(Collectors.toList());
    }
}
