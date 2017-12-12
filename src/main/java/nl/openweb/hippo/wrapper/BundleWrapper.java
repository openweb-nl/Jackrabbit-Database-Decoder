package nl.openweb.hippo.wrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import nl.openweb.hippo.domain.Bundle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.persistence.util.BundleBinding;
import org.apache.jackrabbit.core.persistence.util.ErrorHandling;
import org.apache.jackrabbit.core.persistence.util.NodePropBundle;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BundleWrapper {

    private static BundleBinding binding = new BundleBinding(new ErrorHandling(), null, null, null, null);

    private static final Logger LOG = LoggerFactory.getLogger(BundleWrapper.class);


    protected static final String JSON_SERIALIZATION_ERROR_MSG = "Couldn't write object as JSON string.";

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
/*
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.error(JSON_SERIALIZATION_ERROR_MSG, e);
            return super.toString();
        }
    }*/
}
