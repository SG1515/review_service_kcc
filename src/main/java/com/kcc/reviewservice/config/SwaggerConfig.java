package com.kcc.reviewservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Restaurant API 명세서",
                description = "KCC정보통신 과제 Restaurnat Service",
                version = "v1.0.0")
)

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenAPI() {
        String[] paths = {"/users/**", "/admin/**"};

        return GroupedOpenApi.builder()
                .group("일반사용자, 관리자를 위한 API")
                .pathsToMatch(paths)
                .build();
    }
}
