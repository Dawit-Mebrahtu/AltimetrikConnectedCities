package com.altimetrik.connectedcities.connectedcities.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.altimetrik.connectedcities.connectedcities"))
//                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        Contact contact = new Contact("Dawit Mebrahtu", "https://www.youtube.com/TechPrimers", "dmebrahtu@mum.edu");

        ApiInfo apiInfo = new ApiInfo(
                "Connected Cities REST API",
                "Connected Cities REST API for ALTIMETRIK coding challenge",
                "1.0",
                "Terms of Service",
                "Dawit Mebrahtu",
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }
}

//
//new Contact("TechPrimers", "https://www.youtube.com/TechPrimers",
//        "techprimerschannel@gmail.com"),