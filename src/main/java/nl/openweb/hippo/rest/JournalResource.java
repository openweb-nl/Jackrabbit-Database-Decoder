package nl.openweb.hippo.rest;


import nl.openweb.hippo.domain.Journal;
import nl.openweb.hippo.repository.JournalRepository;
import nl.openweb.hippo.vo.JournalVO;
import nl.openweb.hippo.wrapper.ReadRecordWrapper;
import org.apache.jackrabbit.core.cluster.ClusterRecord;
import org.apache.jackrabbit.core.cluster.ClusterRecordDeserializer;
import org.apache.jackrabbit.core.journal.JournalException;
import org.apache.jackrabbit.core.journal.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journals")
public class JournalResource {

    private final JournalRepository repository;
    private final ClusterRecordDeserializer deserializer = new ClusterRecordDeserializer();

    public JournalResource(JournalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Page<JournalVO> all(@PageableDefault Pageable pageable) {
        return repository.findAllByOrderByIdDesc(pageable)
                .map(this::transform);
    }

    @GetMapping("/{id}")
    public JournalVO all(@PathVariable("id") long id, @PageableDefault Pageable pageable) {
        return transform(repository.findOne(id));
    }

    private JournalVO transform(Journal journal) {
        Record record = new ReadRecordWrapper(journal);
        ClusterRecord clusterRecord = deserialize(record);
        return new JournalVO(clusterRecord, journal);
    }

    private ClusterRecord deserialize(Record record) {
        try {
            return deserializer.deserialize(record);
        } catch (JournalException e) {
            throw new RuntimeException(e);
        }
    }
}
