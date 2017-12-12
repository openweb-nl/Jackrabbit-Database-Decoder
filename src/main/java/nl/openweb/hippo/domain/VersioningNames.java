package nl.openweb.hippo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import nl.openweb.hippo.Runner;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Entity
@Table(name = Runner.VERSIONING_PREFIX + "NAMES")
public class VersioningNames extends Names {

}
