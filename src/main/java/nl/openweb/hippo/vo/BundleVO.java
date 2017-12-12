package nl.openweb.hippo.vo;

import nl.openweb.hippo.domain.Bundle;
import lombok.Getter;
import lombok.Value;

import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.BundleBinding;
import org.apache.jackrabbit.core.persistence.util.ErrorHandling;
import org.apache.jackrabbit.core.persistence.util.NodePropBundle;
import org.apache.jackrabbit.spi.Name;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Senussi on 08/12/2017.
 */

@Getter
public class BundleVO implements Serializable {

    private static BundleBinding binding = new BundleBinding(new ErrorHandling(), null, null,
            null, null);

    private String nodeId;
    private String nodeTypeName;
    private String parentId;
    private Set<String> mixinTypeNames;
    private Set<String> properties;
    private Set<ChildNode> childNodes;
    private Set<String> sharedSet;
    private boolean isReferenceable;


    public BundleVO(Bundle bundle) {
        NodePropBundle nodePropBundle;
        try {
            NodeId nodeId = new NodeId(bundle.getNodeId());
            nodePropBundle = binding.readBundle(new ByteArrayInputStream(bundle.getBundleData()), nodeId);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        if (nodePropBundle != null) {
            this.nodeId = String.valueOf(nodePropBundle.getId());
            this.nodeTypeName = String.valueOf(nodePropBundle.getNodeTypeName());
            this.parentId = String.valueOf(nodePropBundle.getParentId());
            this.properties = nodePropBundle.getPropertyEntries().stream().map(NodePropBundle.PropertyEntry::toString).collect(Collectors.toSet());
            this.childNodes = nodePropBundle.getChildNodeEntries().stream().map(ChildNode::new).collect(Collectors.toSet());
            if (nodePropBundle.getMixinTypeNames() != null)
                this.mixinTypeNames = nodePropBundle.getMixinTypeNames().stream().map(Name::toString).collect(Collectors.toSet());
            if (nodePropBundle.getSharedSet() != null)
                this.sharedSet = nodePropBundle.getSharedSet().stream().map(NodeId::toString).collect(Collectors.toSet());

            this.isReferenceable = nodePropBundle.isReferenceable();
        }

    }


    @Value
    private final class ChildNode {
        private final String id;
        private final String name;

        public ChildNode(NodePropBundle.ChildNodeEntry childNodeEntry) {
            this.id = childNodeEntry.getId() != null ? childNodeEntry.getId().toString() : null;
            this.name = childNodeEntry.getName() != null ? childNodeEntry.getName().toString() : null;
        }
    }

}
