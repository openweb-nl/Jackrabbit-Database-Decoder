package com.aharpour.codelib.vo;

import com.aharpour.codelib.domain.Bundle;
import com.aharpour.codelib.wrapper.NodePropBundleWrapper;
import lombok.Data;
import lombok.Value;
import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.BundleBinding;
import org.apache.jackrabbit.core.persistence.util.ErrorHandling;
import org.apache.jackrabbit.core.persistence.util.NodePropBundle;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
@Value
public class BundleVO implements Serializable {

    private static BundleBinding binding = new BundleBinding(new ErrorHandling(), null, null, null, null);

    private final String bundleId;
    private final NodePropBundleWrapper nodePropBundle;

    public BundleVO(Bundle bundle) {
        try {
            NodeId nodeId = new NodeId(bundle.getNodeId());
            this.bundleId = nodeId.toString();
            NodePropBundle nodePropBundleSuper = binding.readBundle(new ByteArrayInputStream(bundle.getBundleData()), nodeId);
            this.nodePropBundle = new NodePropBundleWrapper(nodePropBundleSuper);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }


}
