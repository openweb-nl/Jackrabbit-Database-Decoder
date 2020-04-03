package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.LockRecord;
import org.apache.jackrabbit.core.id.NodeId;

public class LockRecordWrapper {
    private final LockRecord record;

    public LockRecordWrapper(LockRecord record) {
        this.record = record;
    }

    public NodeId getNodeId() {
        return record.getNodeId();
    }

    public boolean isLock() {
        return record.isLock();
    }

    public boolean isDeep() {
        return record.isDeep();
    }

    public String getUserId() {
        return record.getUserId();
    }

    public String getOwner() {
        return record.getOwner();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
