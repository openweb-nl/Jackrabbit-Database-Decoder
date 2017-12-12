package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.VersioningBinval;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningBinvalRepository extends PagingAndSortingRepository<VersioningBinval, byte[]> {
}
