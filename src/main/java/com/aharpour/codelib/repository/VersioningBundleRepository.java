package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.VersioningBundle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningBundleRepository extends PagingAndSortingRepository<VersioningBundle, byte[]> {
    Optional<VersioningBundle> findOneByNodeId(byte[] nodeId);

}
