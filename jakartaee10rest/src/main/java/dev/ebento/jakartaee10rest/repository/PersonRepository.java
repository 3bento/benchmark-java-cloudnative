package dev.ebento.jakartaee10rest.repository;

import dev.ebento.jakartaee10rest.dto.PersonDTO;
import dev.ebento.jakartaee10rest.entity.PersonEntity;
import dev.ebento.jakartaee10rest.mapper.PersonMapper;
import dev.ebento.jakartaee10rest.mapper.PersonMapperImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Inject
    PersonMapper personMapper;

    @Transactional
    public PersonDTO save(PersonDTO personDTO) {
        PersonEntity personEntity = personMapper.toMap(personDTO);
        em.persist(personEntity);
        return personMapper.toMap(personEntity);
    }

    public PersonDTO findOne(Long id) {
        PersonEntity person = em.find(PersonEntity.class, id);
        return personMapper.toMap(person);
    }

    public List<PersonDTO> findAll() {
        int pageNumber = 1;
        int pageSize = 10;
        List<PersonEntity> persons = em.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return personMapper.toMap(persons);
    }
}
