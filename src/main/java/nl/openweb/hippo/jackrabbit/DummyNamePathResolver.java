package nl.openweb.hippo.jackrabbit;

import org.apache.jackrabbit.spi.Name;
import org.apache.jackrabbit.spi.Path;
import org.apache.jackrabbit.spi.commons.conversion.*;
import org.apache.jackrabbit.spi.commons.name.NameFactoryImpl;
import org.apache.jackrabbit.spi.commons.name.PathFactoryImpl;

import javax.jcr.NamespaceException;

public class DummyNamePathResolver implements NamePathResolver {


    private final NameResolver nResolver = new CachingNameResolver(
            new ParsingNameResolver(NameFactoryImpl.getInstance(), DummyNamespaceResolver.getInstance())
    );
    private final PathResolver pResolver = new ParsingPathResolver(PathFactoryImpl.getInstance(), nResolver);


    public Name getQName(String name) throws IllegalNameException, NamespaceException {
        return nResolver.getQName(name);
    }

    public String getJCRName(Name name) throws NamespaceException {
        return nResolver.getJCRName(name);
    }

    public Path getQPath(String path) throws MalformedPathException, IllegalNameException, NamespaceException {
        return pResolver.getQPath(path);
    }

    public Path getQPath(String path, boolean normalizeIdentifier) throws MalformedPathException, IllegalNameException, NamespaceException {
        return pResolver.getQPath(path, normalizeIdentifier);
    }

    public String getJCRPath(Path path) throws NamespaceException {
        return pResolver.getJCRPath(path);
    }
}
