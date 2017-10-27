package org.springframework.samples.app.person;

import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.app.person.Person;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends CrudRepository<Person, UUID> {

    @Query("SELECT p FROM Person p WHERE last_name = :lastName")
    @Transactional
    Collection<Person> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM Person p WHERE id = :id")
    @Transactional
    Person findById(@Param("id") UUID id);

//    void save(Person person);
}
