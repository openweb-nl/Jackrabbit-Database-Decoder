package nl.openweb.hippo.rest;

import nl.openweb.hippo.domain.Names;
import nl.openweb.hippo.repository.DefaultWsNamesRepository;
import nl.openweb.hippo.repository.VersioningNamesRepository;
import nl.openweb.hippo.vo.Workspace;
import nl.openweb.hippo.wrapper.NamesWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Senussi on 08/12/2017.
 */
@RestController
@RequestMapping("/api/names")
public class NameResource {

    private final DefaultWsNamesRepository defaultWsNamesRepository;
    private final VersioningNamesRepository versioningNamesRepository;

    private final Logger LOG = LoggerFactory.getLogger(NameResource.class);



    public NameResource(DefaultWsNamesRepository defaultWsNamesRepository,
                        VersioningNamesRepository versioningNamesRepository) {
        this.defaultWsNamesRepository = defaultWsNamesRepository;
        this.versioningNamesRepository = versioningNamesRepository;
    }

    @GetMapping("/workspaces/{workspace}")
    public Page<NamesWrapper> all(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        return getNames(workspace, pageable).map(NamesWrapper::new);
    }

    private Page<? extends Names> getNames(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        switch (workspace) {
            case VERSIONING:
                return versioningNamesRepository.findAll(pageable);
            default:
                return defaultWsNamesRepository.findAll(pageable);
        }
    }

}
