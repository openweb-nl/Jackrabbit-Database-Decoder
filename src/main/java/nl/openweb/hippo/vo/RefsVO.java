package nl.openweb.hippo.vo;

import nl.openweb.hippo.domain.Refs;
import lombok.Value;

import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.Serializer;
import org.apache.jackrabbit.core.state.NodeReferences;

import java.io.ByteArrayInputStream;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Value
public class RefsVO {

    private final String nodeId;
    private final String targetNodeId;

    public RefsVO(Refs refs) {
        try {
            NodeId targetId = new NodeId(refs.getNodeId());
            this.nodeId = targetId.toString();
            ByteArrayInputStream in =
                    new ByteArrayInputStream(refs.getRefsData());
            NodeReferences nodeRefs = new NodeReferences(targetId);
            Serializer.deserialize(nodeRefs, in);
            this.targetNodeId = String.valueOf(nodeRefs.getTargetId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
