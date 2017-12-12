package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.Datastore;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface DatastoreRepository extends PagingAndSortingRepository<Datastore, byte[]> {
}
