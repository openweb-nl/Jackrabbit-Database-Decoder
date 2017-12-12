package nl.openweb.hippo.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Entity
@Table(name = "DATASTORE")
@Data
@NoArgsConstructor
public class Datastore {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "LENGTH")
    private Long length;

    @Column(name = "LAST_MODIFIED")
    private Long lastModified;

    @Lob
    @Column(name = "DATA")
    private byte[] data;
}
