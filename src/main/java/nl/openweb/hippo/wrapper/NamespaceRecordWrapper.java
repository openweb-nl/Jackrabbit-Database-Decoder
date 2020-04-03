package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.NamespaceRecord;

public class NamespaceRecordWrapper {

    private final NamespaceRecord record;

    public NamespaceRecordWrapper(NamespaceRecord record) {
        this.record = record;
    }

    public String getOldPrefix() {
        return record.getOldPrefix();
    }

    public String getNewPrefix() {
        return record.getNewPrefix();
    }

    public String getUri() {
        return record.getUri();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
