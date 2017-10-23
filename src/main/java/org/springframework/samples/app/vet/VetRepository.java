//package org.springframework.samples.app.vet;
//
//import java.util.Collection;
//
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.repository.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Repository class for <code>Vet</code> domain objects All method names are compliant with Spring Data naming
// * conventions so this interface can easily be extended for Spring Data See here:
// * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
// */
//public interface VetRepository extends Repository<Vet, Integer> {
//
//    /**
//     * Retrieve all <code>Vet</code>s from the data store.
//     *
//     * @return a <code>Collection</code> of <code>Vet</code>s
//     */
//    @Transactional(readOnly = true)
//    @Cacheable("vets")
//    Collection<Vet> findAll() throws DataAccessException;
//}
