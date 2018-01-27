package com.yangwenjie.delayqueue;

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
 * Create By IntelliJ IDEA
 *
 * @author Yang WenJie
 * @date 2018/1/4 15:04
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yangwenjie.delayqueue"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" Internet-Queuing restful apis")
                .description("延迟消息队列接口文档")
                 .termsOfServiceUrl("https://github.com/yangwenjie88/delay-queue")
                .contact("Yang WenJie")
                .version("1.0")
                .build();
    }
}
