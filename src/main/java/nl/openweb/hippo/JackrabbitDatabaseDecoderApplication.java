package nl.openweb.hippo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JackrabbitDatabaseDecoderApplication {

	public static final String VERSIONING_PREFIX = "VERSION_";
	public static final String DEFAULT_WS_PREFIX = "DEFAULT_";

	public static void main(String[] args) {
		SpringApplication.run(JackrabbitDatabaseDecoderApplication.class, args);
	}
}
