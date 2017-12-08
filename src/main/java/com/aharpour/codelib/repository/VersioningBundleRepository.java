package com.aharpour.codelib.repository;

import com.aharpour.codelib.domain.VersioningBundle;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
public interface VersioningBundleRepository extends CrudRepository<VersioningBundle, byte[]> {
}
