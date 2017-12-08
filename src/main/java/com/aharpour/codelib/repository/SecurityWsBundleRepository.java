package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.SecurityWsBundle;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface SecurityWsBundleRepository extends CrudRepository<SecurityWsBundle, byte[]> {
}