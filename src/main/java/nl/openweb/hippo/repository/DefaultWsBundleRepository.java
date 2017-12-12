package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.DefaultWsBundle;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface DefaultWsBundleRepository extends PagingAndSortingRepository<DefaultWsBundle, byte[]> {
    Optional<DefaultWsBundle> findOneByNodeId(byte[] nodeId);
}
