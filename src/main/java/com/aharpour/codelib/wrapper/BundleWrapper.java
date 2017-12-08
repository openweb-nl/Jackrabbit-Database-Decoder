package com.aharpour.codelib.wrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.aharpour.codelib.domain.Bundle;

import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.BundleBinding;
import org.apache.jackrabbit.core.persistence.util.ErrorHandling;
import org.apache.jackrabbit.core.persistence.util.NodePropBundle;

import lombok.Data;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
@Data
public class BundleWrapper {

    private static BundleBinding binding = new BundleBinding(new ErrorHandling(), null, null, null, null);

    private final String bundleId;
    private final NodePropBundle nodePropBundle;

    public BundleWrapper(Bundle bundle) {
        try {
            NodeId nodeId = new NodeId(bundle.getNodeId());
            this.bundleId = nodeId.toString();
            this.nodePropBundle = binding.readBundle(new ByteArrayInputStream(bundle.getBundleData()), nodeId);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
