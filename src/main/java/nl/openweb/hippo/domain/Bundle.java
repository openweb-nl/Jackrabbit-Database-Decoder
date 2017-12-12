package nl.openweb.hippo.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Bundle {

    @Id
    @Lob
    @Column(name = "NODE_ID")
    private byte[] nodeId;
    @Lob
    @Column(name = "BUNDLE_DATA")
    private byte[] bundleData;
}
