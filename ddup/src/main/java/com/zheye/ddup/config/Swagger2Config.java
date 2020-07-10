package com.zheye.ddup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static final DocumentationType SWAGGER_DDUP = new DocumentationType("swagger-ddup", "1.0");

    @Bean
    public Docket productApi() {
        return new Docket(SWAGGER_DDUP)
//                .host("12345678") // base url
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zheye.ddup.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DdUp")
                .description("DAY_DAY_UP")
                .version("1.0.0")
                .build();
    }
}
