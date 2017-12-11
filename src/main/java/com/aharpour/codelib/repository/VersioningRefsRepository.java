package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.VersioningBundle;
import com.aharpour.codelib.domain.VersioningRefs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningRefsRepository extends PagingAndSortingRepository<VersioningRefs, byte[]> {
    Optional<VersioningRefs> findOneByNodeId(byte[] nodeId);

}
