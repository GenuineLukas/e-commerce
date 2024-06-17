package org.delivery.api.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration:
 * Indicates that this class contains one or more bean methods annotated with @Bean
 * and may be processed by the Spring container to generate bean definitions and service requests at runtime.
 * 이 클래스가 하나 이상의 @Bean 어노테이션이 붙은 메서드를 포함하고 있음을 나타내며,
 * Spring 컨테이너가 런타임에 빈 정의 및 서비스 요청을 생성하기 위해 처리할 수 있음을 나타냅니다.
 */
@Configuration
public class SwaggerConfig {

    /**
     * @Bean:
     * Indicates that a method produces a bean to be managed by the Spring container.
     * 이 메서드가 Spring 컨테이너에 의해 관리되는 빈을 생성함을 나타냅니다.
     *
     * @param objectMapper ObjectMapper instance to be used by ModelResolver.
     *                     ModelResolver에서 사용할 ObjectMapper 인스턴스.
     * @return ModelResolver instance configured with the provided ObjectMapper.
     *         제공된 ObjectMapper로 구성된 ModelResolver 인스턴스.
     */
    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper){
        return new ModelResolver(objectMapper);
    }
}
