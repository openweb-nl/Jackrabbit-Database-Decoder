package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.VersioningNames;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningNamesRepository extends PagingAndSortingRepository<VersioningNames, byte[]> {
}
