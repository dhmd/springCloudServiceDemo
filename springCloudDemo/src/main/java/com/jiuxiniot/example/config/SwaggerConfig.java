package com.jiuxiniot.example.config;

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
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author Lq
 * @Date 2020/6/8 10:01
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
//@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                //基于包扫描
                .apis(RequestHandlerSelectors.basePackage("com.jiuxiniot"))
                .paths(PathSelectors.any()) //regex("/.*")
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringCloudDemo服务")
                .description("swagger在线接口文档")
                .version("1.0")
                .build();
    }

}
