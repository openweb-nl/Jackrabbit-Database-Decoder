package com.aharpour.codelib.wrapper;

import java.io.ByteArrayInputStream;

import com.aharpour.codelib.domain.Refs;

import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.Serializer;
import org.apache.jackrabbit.core.state.NodeReferences;

import lombok.Data;

/**
 * @author Ebrahim Aharpour
 * @since 11/19/2017
 */
@Data
public class RefsWrapper {

    private final String nodeId;
    private final NodeReferences nodeRefs;

    public RefsWrapper(Refs refs) {
        try {
            NodeId targetId = new NodeId(refs.getNodeId());
            this.nodeId = targetId.toString();
            ByteArrayInputStream in =
                    new ByteArrayInputStream(refs.getRefsData());
            NodeReferences nodeRefs = new NodeReferences(targetId);
            Serializer.deserialize(nodeRefs, in);
            this.nodeRefs = nodeRefs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
