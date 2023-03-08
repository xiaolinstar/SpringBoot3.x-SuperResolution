package com.xiaolin.superresolution.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * @author xlxing
 * 给controller配置自动化测试前端
 * SpringBoot的设计思想是习惯大于配置，因此，不写下面的Bean也可以使用SwaggerUI
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi(@Value("${spring.application.name}") String applicationName, ObjectProvider<BuildProperties> buildProperties) {
        OpenAPI openApi = new OpenAPI();
        openApi.info(new Info().title(applicationName)
                .description("Single Image SuperResolution")
                .version(Optional.ofNullable(buildProperties.getIfAvailable()).map(BuildProperties::getVersion).orElse("1.0.0"))
        );
        return openApi;
    }
}
