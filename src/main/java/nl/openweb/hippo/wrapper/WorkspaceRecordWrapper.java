package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.WorkspaceRecord;

public class WorkspaceRecordWrapper {

    private final WorkspaceRecord record;

    public WorkspaceRecordWrapper(WorkspaceRecord record) {
        this.record = record;
    }

    public int getActionType() {
        return record.getActionType();
    }

    public WorkspaceRecord.Action getCreateWorkspaceAction() {
        return record.getCreateWorkspaceAction();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
