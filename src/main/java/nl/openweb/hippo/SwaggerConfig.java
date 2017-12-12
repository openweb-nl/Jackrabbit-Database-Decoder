package nl.openweb.hippo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Senussi on 11/12/2017.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("nl.openweb.hippo.rest"))
	     .paths(PathSelectors.ant("/api/**"))
	      .build()
	      .apiInfo(apiInfo());
	}



	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("jackrabbit-database-decoder API v1.0")
	                .description("jackrabbit-database-decoder api ...")
//	                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
//	                .license("Apache License Version 2.0")
//	                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
	                .version("1.0")
	                .build();
	    }
}
