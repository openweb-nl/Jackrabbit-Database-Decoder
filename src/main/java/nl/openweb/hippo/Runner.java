package nl.openweb.hippo;

import nl.openweb.hippo.domain.Binval;
import nl.openweb.hippo.domain.Bundle;
import nl.openweb.hippo.domain.Names;
import nl.openweb.hippo.domain.Refs;
import nl.openweb.hippo.repository.*;
import nl.openweb.hippo.wrapper.BinvalWrapper;
import nl.openweb.hippo.wrapper.BundleWrapper;
import nl.openweb.hippo.wrapper.NamesWrapper;
import nl.openweb.hippo.wrapper.RefsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

import nl.openweb.hippo.repository.*;

/**
 * @author Ebrahim Aharpour
 * @since 11/18/2017
 */
@Component
public class Runner implements CommandLineRunner {

    public static final String VERSIONING_PREFIX = "VERSION_";
    public static final String DEFAULT_WS_PREFIX = "DEFAULT_";
    public static final String SECURITY_WS_PREFIX = "SECURITY_";

    @Autowired
    private DefaultWsBundleRepository defaultWsBundleRepository;
    @Autowired
    private DefaultWsBinvalRepository defaultWsBinvalRepository;
    @Autowired
    private DefaultWsRefsRepository defaultWsRefsRepository;
    @Autowired
    private DefaultWsNamesRepository defaultWsNamesRepository;
    @Autowired
    private VersioningBundleRepository versioningBundleRepository;
    @Autowired
    private VersioningBinvalRepository versioningBinvalRepository;
    @Autowired
    private VersioningRefsRepository versioningRefsRepository;
    @Autowired
    private VersioningNamesRepository versioningNamesRepository;


    @Override
    public void run(String... args) throws Exception {
       /* System.out.println("Default Workspace");
        printBundle(defaultWsBundleRepository.findAll());
        printRefs(defaultWsRefsRepository.findAll());
        printNames(defaultWsNamesRepository.findAll());
        printBinval(defaultWsBinvalRepository.findAll());


        System.out.println("Versioning Workspace");
        printBundle(versioningBundleRepository.findAll());
        printRefs(versioningRefsRepository.findAll());
        printNames(versioningNamesRepository.findAll());
        printBinval(versioningBinvalRepository.findAll());*/

    }

    private <T extends Names> void printNames(Iterable<T> all) {
        System.out.println("Names");
        StreamSupport.stream(all.spliterator(), true)
                .map(NamesWrapper::new)
                .forEach(System.out::println);
    }

    private <T extends Binval> void printBinval(Iterable<T> all) {
        System.out.println("Binval");
        StreamSupport.stream(all.spliterator(), true)
                .map(BinvalWrapper::new)
                .forEach(System.out::println);
    }

    private <T extends Bundle> void printBundle(Iterable<T> all) {
        System.out.println("Bundles");
        StreamSupport.stream(all.spliterator(), false)
                .map(BundleWrapper::new)
                .forEach(System.out::println);
    }

    private <T extends Refs> void printRefs(Iterable<T> all) {
        System.out.println("Refs");
        StreamSupport.stream(all.spliterator(), false)
                .map(RefsWrapper::new)
                .forEach(System.out::println);
    }

}
