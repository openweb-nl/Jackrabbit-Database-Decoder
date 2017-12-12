package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.VersioningNames;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningNamesRepository extends PagingAndSortingRepository<VersioningNames, byte[]> {
}
