package org.delivery.api.config.objectMapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ObjectMapperConfig 클래스
 *
 * 이 클래스는 Jackson ObjectMapper를 구성하는 스프링 설정 클래스입니다.
 */

@Configuration
public class ObjectMapperConfig {

    /**
     * @Bean:
     * 이 메서드가 생성하는 ObjectMapper 인스턴스를 스프링 컨텍스트에 빈으로 등록합니다.
     */
    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();

        /**
         * objectMapper.registerModule(new Jdk8Module()):
         * JDK 8 이후 클래스들을 처리하기 위한 모듈을 등록합니다.
         */
        objectMapper.registerModule(new Jdk8Module());

        /**
         * objectMapper.registerModule(new JavaTimeModule()):
         * Java 8 날짜와 시간 API (java.time 패키지)를 처리하기 위한 모듈을 등록합니다.
         */
        objectMapper.registerModule(new JavaTimeModule());

        /**
         * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false):
         * JSON 문자열을 역직렬화할 때, 알 수 없는 속성이 존재해도 예외를 발생시키지 않고 무시하도록 설정합니다.
         */
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        /**
         * objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false):
         * 비어있는 빈 객체를 직렬화할 때 예외가 발생하지 않도록 설정합니다.
         */
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        /**
         * objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS):
         * 날짜와 시간을 타임스탬프로 직렬화하지 않도록 설정합니다.
         * 예시)
         * 타임 스탬프로 직렬화
         * json
         * Copy code
         * {
         *   "date": 1720657800000
         * }
         * 문자열로 직렬화
         * json
         * Copy code
         * {
         *   "date": "2024-06-09T12:30:00"
         * }
         * objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
         * 설정을 통해 날짜와 시간 데이터를 타임 스탬프가 아닌 문자열 형식으로 직렬화하도록 설정할 수 있습니다.
         * 이렇게 하면 JSON 데이터를 읽을 때 더 인간 친화적으로 이해할 수 있습니다.
         */
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        /**
         * objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy()):
         * 속성명을 스네이크 케이스로 변환하도록 설정합니다.
         */
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

        return objectMapper;
    }
}
