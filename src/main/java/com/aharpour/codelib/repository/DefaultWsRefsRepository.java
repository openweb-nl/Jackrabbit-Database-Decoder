package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.DefaultWsRefs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface DefaultWsRefsRepository extends PagingAndSortingRepository<DefaultWsRefs, byte[]> {

    Optional<DefaultWsRefs> findOneByNodeId(byte[] nodeId);
}
