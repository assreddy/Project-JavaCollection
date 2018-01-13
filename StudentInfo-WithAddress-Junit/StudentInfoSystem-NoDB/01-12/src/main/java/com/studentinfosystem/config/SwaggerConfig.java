package com.studentinfosystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.studentinfosystem.controller"))
				.paths(regex("/studentinfo.*"))
				.build()
				.apiInfo(metaData());

	}

	@SuppressWarnings("deprecation")
	private ApiInfo metaData() {
        		return new ApiInfoBuilder()
        	     .title("Spring Boot Student API.")
                 .description("Spring Boot Student API")
                 .termsOfServiceUrl("http://springfox.io")
                 .contact("@info.com") 
                 .license("Apache License Version 2.0")
                 .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                 .version("2.0")
                 .build();
    }

}

