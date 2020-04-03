package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.NodeTypeRecord;

import java.util.Collection;
import java.util.Collections;

public class NodeTypeRecordWrapper {

    private final NodeTypeRecord record;

    public NodeTypeRecordWrapper(NodeTypeRecord record) {
        this.record = record;
    }

    public int getOperation() {
        return record.getOperation();
    }

    public Collection getCollection() {
        // TODO return record.getCollection();
        return Collections.emptyList();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
