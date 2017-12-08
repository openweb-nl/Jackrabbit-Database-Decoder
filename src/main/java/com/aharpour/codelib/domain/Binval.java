package com.aharpour.codelib.domain;

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
public abstract class Binval {

    @Id
    @Column(name = "BINVAL_ID")
    private String binvalId;
    @Lob
    @Column(name = "BINVAL_DATA")
    private byte[] binvalData;
}
