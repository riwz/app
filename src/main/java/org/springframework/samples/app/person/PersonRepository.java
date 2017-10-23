//package org.springframework.samples.app.owner;
//
//import java.util.Collection;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Repository class for <code>Person</code> domain objects All method names are compliant with Spring Data naming
// * conventions so this interface can easily be extended for Spring Data See here:
// * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
// */
//public interface OwnerRepository extends Repository<Person, Integer> {
//
//    /**
//     * Retrieve {@link Person}s from the data store by last name, returning all owners
//     * whose last name <i>starts</i> with the given name.
//     * @param lastName Value to search for
//     * @return a Collection of matching {@link Person}s (or an empty Collection if none
//     * found)
//     */
//    @Query("SELECT DISTINCT person FROM Person person left join fetch person.pets WHERE person.lastName LIKE :lastName")
//    @Transactional(readOnly = true)
//    Collection<Person> findByLastName(@Param("lastName") String lastName);
//
//    /**
//     * Retrieve an {@link Person} from the data store by id.
//     * @param id the id to search for
//     * @return the {@link Person} if found
//     */
//    @Query("SELECT person FROM Person person left join fetch person.pets WHERE person.id =:id")
//    @Transactional(readOnly = true)
//    Person findById(@Param("id") Integer id);
//
//    /**
//     * Save an {@link Person} to the data store, either inserting or updating it.
//     * @param person the {@link Person} to save
//     */
//    void save(Person person);
//}
