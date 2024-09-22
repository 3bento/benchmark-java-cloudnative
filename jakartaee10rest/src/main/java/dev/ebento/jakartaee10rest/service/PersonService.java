package dev.ebento.jakartaee10rest.service;

import dev.ebento.jakartaee10rest.dto.PersonDTO;
import dev.ebento.jakartaee10rest.repository.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonRepository personRepository;

    public PersonDTO save(PersonDTO personDTO) {
        return personRepository.save(personDTO);
    }

    public PersonDTO findOne(Long id) {
        return personRepository.findOne(id);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll();
    }
}