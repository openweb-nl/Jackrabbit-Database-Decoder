package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.DefaultWsNames;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface DefaultWsNamesRepository extends PagingAndSortingRepository<DefaultWsNames, byte[]> {
}
