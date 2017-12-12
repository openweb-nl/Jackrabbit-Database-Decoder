package nl.openweb.hippo.repository;

import nl.openweb.hippo.domain.DefaultWsRefs;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface DefaultWsRefsRepository extends PagingAndSortingRepository<DefaultWsRefs, byte[]> {

    Optional<DefaultWsRefs> findOneByNodeId(byte[] nodeId);
}
