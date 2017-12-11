package com.aharpour.codelib.rest;

import com.aharpour.codelib.domain.Bundle;
import com.aharpour.codelib.domain.DefaultWsBundle;
import com.aharpour.codelib.repository.DefaultWsBundleRepository;
import com.aharpour.codelib.repository.VersioningBundleRepository;
import com.aharpour.codelib.vo.Workspace;
import com.aharpour.codelib.wrapper.BundleWrapper;
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
@RequestMapping("/api/bundles")
public class BundleResource {

    private final DefaultWsBundleRepository defaultWsBundleRepository;
    private final VersioningBundleRepository versioningBundleRepository;

    private final Logger LOG = LoggerFactory.getLogger(BundleResource.class);


    public BundleResource(DefaultWsBundleRepository defaultWsBundleRepository, VersioningBundleRepository versioningBundleRepository) {
        this.defaultWsBundleRepository = defaultWsBundleRepository;
        this.versioningBundleRepository = versioningBundleRepository;
    }

    @GetMapping("/workspaces/{workspace}")
    public Page<String> all(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        return getBundles(workspace, pageable).map(BundleWrapper::new).map(BundleWrapper::toString);
    }

    @GetMapping("/{bundleId}/workspaces/{workspace}")
    public String one(@PathVariable UUID bundleId, @PathVariable Workspace workspace) {


        return getBundle(bundleId, workspace).map(BundleWrapper::new).map(BundleWrapper::toString)
                .orElseThrow(() -> new EntityNotFoundException(String.
                        format("No bundle is found by UUID[%s], in[%s] workspace", bundleId, workspace)));
    }


    private Page<? extends Bundle> getBundles(@PathVariable Workspace workspace, @PageableDefault Pageable pageable) {

        switch (workspace) {
            case VERSIONING:
                return versioningBundleRepository.findAll(pageable);
            default:
                return defaultWsBundleRepository.findAll(pageable);
        }
    }

    private Optional<? extends Bundle> getBundle(@PathVariable UUID bundleId, @PathVariable Workspace workspace) {

        switch (workspace) {
            case VERSIONING:
                return versioningBundleRepository.findOneByNodeId(new NodeId(bundleId).getRawBytes());
            default:
                return defaultWsBundleRepository.findOneByNodeId(new NodeId(bundleId).getRawBytes());
        }
    }

}
