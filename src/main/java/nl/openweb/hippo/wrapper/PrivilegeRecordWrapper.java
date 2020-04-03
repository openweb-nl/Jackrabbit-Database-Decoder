package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.PrivilegeRecord;
import org.apache.jackrabbit.spi.PrivilegeDefinition;

import java.util.Collection;

public class PrivilegeRecordWrapper {
    private final PrivilegeRecord record;

    public PrivilegeRecordWrapper(PrivilegeRecord record) {
        this.record = record;
    }

    public Collection<PrivilegeDefinition> getDefinitions() {
        return record.getDefinitions();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
