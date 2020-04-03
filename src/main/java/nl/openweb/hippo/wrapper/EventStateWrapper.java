package nl.openweb.hippo.wrapper;

import org.apache.jackrabbit.core.SessionImpl;
import org.apache.jackrabbit.core.id.NodeId;
import org.apache.jackrabbit.core.nodetype.NodeTypeManagerImpl;
import org.apache.jackrabbit.core.observation.EventState;
import org.apache.jackrabbit.core.value.InternalValue;
import org.apache.jackrabbit.spi.Name;

import javax.jcr.nodetype.NodeType;
import javax.jcr.observation.Event;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventStateWrapper {

    private final EventState state;

    public EventStateWrapper(EventState state) {
        this.state = state;
    }

    public String getType() {
        switch (state.getType()) {
            case Event.NODE_ADDED:
                return "NODE_ADDED";
            case Event.NODE_MOVED:
                return "NODE_MOVED";
            case Event.NODE_REMOVED:
                return "NODE_REMOVED";
            case Event.PERSIST:
                return "PERSIST";
            case Event.PROPERTY_ADDED:
                return "PROPERTY_ADDED";
            case Event.PROPERTY_CHANGED:
                return "PROPERTY_CHANGED";
            case Event.PROPERTY_REMOVED:
                return "PROPERTY_REMOVED";
            default:
                throw new IllegalArgumentException("Unexpected type.");
        }
    }

    public String getParentId() {
        return objToString(state.getChildId());
    }

    public String getParentPath() {
        return objToString(state.getParentPath());
    }

    public String getChildId() {
        NodeId childId = state.getChildId();
        return objToString(childId);
    }

    public String getChildRelPath() {
        return objToString(state.getChildRelPath());
    }

    public Name getNodeType() {
        return state.getNodeType();
    }

    public Set<Name> getMixinNames() {
        return state.getMixinNames();
    }

    public Set<NodeType> getNodeTypes(NodeTypeManagerImpl ntMgr) {
        return state.getNodeTypes(ntMgr);
    }

    public String getUserId() {
        return state.getUserId();
    }

    public Map<String, InternalValue> getInfo() {
        return state.getInfo();
    }

    public static String getCommonPath(List<EventState> events, SessionImpl session) {
        return EventState.getCommonPath(events, session);
    }

    private String objToString(Object object) {
        return object != null ? object.toString() : null;
    }
}
