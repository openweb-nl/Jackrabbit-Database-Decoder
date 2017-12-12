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
public abstract class Names {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
