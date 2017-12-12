package nl.openweb.hippo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;


import static nl.openweb.hippo.JackrabbitDatabaseDecoderApplication.DEFAULT_WS_PREFIX;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Entity
@Table(name = DEFAULT_WS_PREFIX + "REFS")
public class DefaultWsRefs extends Refs {

}
