package nl.openweb.hippo;

import nl.openweb.hippo.domain.DefaultWsBundle;
import nl.openweb.hippo.repository.DefaultWsBundleRepository;
import org.apache.jackrabbit.core.id.NodeId;
import org.springframework.boot.CommandLineRunner;

import java.io.FileOutputStream;
import java.io.PrintStream;

//@Component
class DumpIds implements CommandLineRunner {

    private final DefaultWsBundleRepository defaultWsBundleRepository;

    DumpIds(DefaultWsBundleRepository defaultWsBundleRepository) {
        this.defaultWsBundleRepository = defaultWsBundleRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        try (PrintStream out = new PrintStream(new FileOutputStream("ids.txt"))) {
            for (DefaultWsBundle i : defaultWsBundleRepository.findAll()) {
                out.println(new NodeId(i.getNodeId()).toString());
            }
        }


    }
}
