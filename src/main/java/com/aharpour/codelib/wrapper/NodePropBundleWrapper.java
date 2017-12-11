package com.aharpour.codelib.wrapper;

import lombok.Data;
import lombok.Value;
import org.apache.jackrabbit.core.persistence.util.NodePropBundle;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Senussi on 08/12/2017.
 */

@Data
public class NodePropBundleWrapper extends NodePropBundle implements Serializable{

    private Collection<PropertyEntry> propertyEntries = new ArrayList<>();

    public NodePropBundleWrapper(NodePropBundle nodePropBundle) {
        super(nodePropBundle.getId());
        BeanUtils.copyProperties(nodePropBundle, this);
        this.propertyEntries = nodePropBundle.getPropertyEntries();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
