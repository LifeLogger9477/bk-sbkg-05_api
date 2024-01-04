package me.sbkg.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author : ms.Lee
 * date   : 2024-01-04
 */
// 참고
// https://velog.io/@imuu2256/Spring-Spring-boot-3.2.0%EC%97%90%EC%84%9C-Spring-Open-API-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-Swagger-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
@OpenAPIDefinition(
    info = @Info(
        title = "Spring Boot Open API Test with Swagger",
        description = "테스트용 API 명세서입니다",
        version = "1.0.0"
    )
)
@Configuration
public class SwaggerConfiguration {

  @Bean
  public GroupedOpenApi testAPI() {

    String[] paths = { "/**" };

    return GroupedOpenApi.builder()
        .group( "테스트 API 1.0.0" )
        .pathsToMatch( paths )
        .build();
  }
}
