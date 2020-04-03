package nl.openweb.hippo.wrapper;

import lombok.experimental.Delegate;
import nl.openweb.hippo.domain.Journal;
import nl.openweb.hippo.jackrabbit.DummyNamePathResolver;
import nl.openweb.hippo.jackrabbit.DummyNamespaceResolver;
import org.apache.jackrabbit.core.journal.ReadRecord;
import org.apache.jackrabbit.core.journal.Record;
import org.apache.jackrabbit.spi.commons.conversion.NamePathResolver;
import org.apache.jackrabbit.spi.commons.namespace.NamespaceResolver;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ReadRecordWrapper implements Record {

    private NamespaceResolver resolver = new DummyNamespaceResolver();
    private NamePathResolver npResolver = new DummyNamePathResolver();

    @Delegate
    private final ReadRecord record;

    public ReadRecordWrapper(Journal journal) {
        byte[] revisionData = journal.getRevisionData();
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(revisionData));
        this.record = new ReadRecord(journal.getJournalId(), journal.getProducerId(), journal.getId(), in,
                revisionData.length, resolver, npResolver);
    }


}
