package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.VersioningRefs;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningRefsRepository extends PagingAndSortingRepository<VersioningRefs, byte[]> {
    Optional<VersioningRefs> findOneByNodeId(byte[] nodeId);

}
