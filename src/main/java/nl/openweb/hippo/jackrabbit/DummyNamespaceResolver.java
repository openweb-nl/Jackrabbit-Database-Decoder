package nl.openweb.hippo.jackrabbit;

import org.apache.jackrabbit.spi.Name;
import org.apache.jackrabbit.spi.commons.namespace.NamespaceResolver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DummyNamespaceResolver implements NamespaceResolver {

    private static final Pattern PATTERN = Pattern.compile("https?://([^//]+/){1,3}([^//]+)/nt/[0-9\\.]+");

    private static final NamespaceResolver INSTANCE = new DummyNamespaceResolver();

    @Override
    public String getURI(String prefix) {
        switch (prefix) {
            case Name.NS_EMPTY_PREFIX:
                return Name.NS_DEFAULT_URI;
            case Name.NS_JCR_PREFIX:
                return Name.NS_JCR_URI;
            case Name.NS_MIX_PREFIX:
                return Name.NS_MIX_URI;
            case Name.NS_NT_PREFIX:
                return Name.NS_NT_URI;
            case Name.NS_REP_PREFIX:
                return Name.NS_REP_URI;
            case Name.NS_SV_PREFIX:
                return Name.NS_SV_URI;
            case Name.NS_XML_PREFIX:
                return Name.NS_XML_URI;
            case Name.NS_XMLNS_PREFIX:
                return Name.NS_XMLNS_URI;
            case "hippo":
                return "http://www.onehippo.org/jcr/hippo/nt/2.0.4";
            case "hst":
                return "http://www.hippoecm.org/hst/nt/2.1";
            default:
                return "http://www.onehippo.org/" + prefix + "/nt/1.0";
        }
    }

    @Override
    public String getPrefix(String uri) {
        switch (uri) {
            case Name.NS_DEFAULT_URI:
                return Name.NS_EMPTY_PREFIX;
            case Name.NS_JCR_URI:
                return Name.NS_JCR_PREFIX;
            case Name.NS_MIX_URI:
                return Name.NS_MIX_PREFIX;
            case Name.NS_NT_URI:
                return Name.NS_NT_PREFIX;
            case Name.NS_REP_URI:
                return Name.NS_REP_PREFIX;
            case Name.NS_SV_URI:
                return Name.NS_SV_PREFIX;
            case Name.NS_XML_URI:
                return Name.NS_XML_PREFIX;
            case Name.NS_XMLNS_URI:
                return Name.NS_XMLNS_PREFIX;
            case "http://www.onehippo.org/jcr/hippo/nt/2.0.4":
                return "hippo";
            case "http://www.hippoecm.org/hst/nt/2.1":
                return "hst";
            default:
                Matcher matcher = PATTERN.matcher(uri);
                if (matcher.matches()) {
                    return matcher.group(2);
                } else {
                    return "mock";
                }
        }
    }

    public static NamespaceResolver getInstance() {
        return INSTANCE;
    }
}
