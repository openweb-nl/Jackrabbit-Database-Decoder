package nl.openweb.hippo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "REPOSITORY_JOURNAL")
public class Journal {

    @Id
    @Column(name = "REVISION_ID")
    private Long id;

    @Column(name = "JOURNAL_ID")
    private String journalId;

    @Column(name = "PRODUCER_ID")
    private String producerId;

    @Lob
    @Column(name = "REVISION_DATA")
    private byte[] revisionData;
}
