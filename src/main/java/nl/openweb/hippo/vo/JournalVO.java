package nl.openweb.hippo.vo;

import lombok.Data;
import nl.openweb.hippo.domain.Journal;
import nl.openweb.hippo.wrapper.*;
import org.apache.jackrabbit.core.cluster.*;

@Data
public class JournalVO {

    private String type;
    private String journalId;
    private String producerId;
    private Object record;

    public JournalVO(ClusterRecord clusterRecord, Journal journal) {
        this.journalId = journal.getJournalId();
        this.producerId = journal.getProducerId();
        type = clusterRecord.getClass().getSimpleName();
        if (clusterRecord instanceof ChangeLogRecord) {
            this.record = new ChangeLogRecordWrapper((ChangeLogRecord) clusterRecord);
        } else if (clusterRecord instanceof NodeTypeRecord) {
            this.record = new NodeTypeRecordWrapper((NodeTypeRecord) clusterRecord);
        } else if (clusterRecord instanceof NamespaceRecord) {
            this.record = new NamespaceRecordWrapper((NamespaceRecord) clusterRecord);
        } else if (clusterRecord instanceof LockRecord) {
            this.record = new LockRecordWrapper((LockRecord) clusterRecord);
        } else if (clusterRecord instanceof PrivilegeRecord) {
            this.record = new PrivilegeRecordWrapper((PrivilegeRecord) clusterRecord);
        } else if (clusterRecord instanceof WorkspaceRecord) {
            this.record = new WorkspaceRecordWrapper((WorkspaceRecord) clusterRecord);
        } else {
            throw new IllegalArgumentException("Unknown type.");
        }
    }
}
