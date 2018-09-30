package nl.openweb.hippo.rest;

import nl.openweb.hippo.domain.Refs;
import nl.openweb.hippo.repository.DefaultWsRefsRepository;
import nl.openweb.hippo.repository.VersioningRefsRepository;
import nl.openweb.hippo.vo.RefsVO;
import nl.openweb.hippo.vo.Workspace;
import org.apache.jackrabbit.core.id.NodeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Senussi on 08/12/2017.
 */
@RestController
@RequestMapping("/api/refs")
public class RefsResource {

    private final DefaultWsRefsRepository defaultWsRefsRepository;

    private final VersioningRefsRepository versioningRefsRepository;

    private final Logger LOG = LoggerFactory.getLogger(RefsResource.class);


    public RefsResource(DefaultWsRefsRepository defaultWsRefsRepository, VersioningRefsRepository versioningRefsRepository) {
        this.defaultWsRefsRepository = defaultWsRefsRepository;
        this.versioningRefsRepository = versioningRefsRepository;
    }

    @GetMapping("/workspaces/{workspace}")
    public Page<RefsVO> all(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        return getRefs(workspace, pageable).map(RefsVO::new);
    }

    @GetMapping("/workspaces/{workspace}/{nodeId}")
    public RefsVO one(@PathVariable UUID nodeId, @PathVariable Workspace workspace){
      return getRef(nodeId, workspace)
              .map(RefsVO::new)
              .orElseThrow(() -> new EntityNotFoundException(String.
                      format("No Refs is found by UUID[%s], in[%s] workspace", nodeId, workspace)));
    }

    private Page<? extends Refs> getRefs(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        switch (workspace) {
            case VERSIONING:
                return versioningRefsRepository.findAll(pageable);
            default:
                return defaultWsRefsRepository.findAll(pageable);
        }
    }

    private Optional<? extends Refs> getRef(@PathVariable UUID bundleId, @PathVariable Workspace workspace) {

        switch (workspace) {
            case VERSIONING:
                return versioningRefsRepository.findOneByNodeId(new NodeId(bundleId).getRawBytes());
            default:
                return defaultWsRefsRepository.findOneByNodeId(new NodeId(bundleId).getRawBytes());
        }
    }

}
