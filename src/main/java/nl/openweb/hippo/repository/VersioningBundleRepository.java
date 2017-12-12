package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.VersioningBundle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningBundleRepository extends PagingAndSortingRepository<VersioningBundle, byte[]> {
    Optional<VersioningBundle> findOneByNodeId(byte[] nodeId);

}
