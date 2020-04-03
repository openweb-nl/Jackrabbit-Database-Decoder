package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.cluster.ChangeLogRecord;
import org.apache.jackrabbit.core.state.ChangeLog;

import java.util.List;
import java.util.stream.Collectors;

public class ChangeLogRecordWrapper  {

    private final ChangeLogRecord record;

    public ChangeLogRecordWrapper(ChangeLogRecord record) {
        this.record = record;
    }

    public ChangeLog getChanges() {
        return record.getChanges();
    }

    public List<EventStateWrapper> getEvents() {
        return record.getEvents().stream()
                .map(EventStateWrapper::new)
                .collect(Collectors.toList());

    }

    public long getTimestamp() {
        return record.getTimestamp();
    }

    public String getUserData() {
        return record.getUserData();
    }

    public long getRevision() {
        return record.getRevision();
    }

    public String getWorkspace() {
        return record.getWorkspace();
    }
}
