package org.delivery.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Configuration:
 * 이 클래스가 스프링의 설정 클래스로 사용됨을 나타냅니다.
 */
@Configuration
/**
 * @EntityScan:
 * JPA 엔티티 클래스를 스캔할 패키지를 지정합니다.
 * 이 설정을 통해 "org.delivery.db" 패키지 내의 엔티티 클래스들을 스캔하여 JPA가 인식할 수 있도록 합니다.
 */
@EntityScan(basePackages = "org.delivery.db")
/**
 * @EnableJpaRepositories:
 * JPA 리포지토리를 스캔할 패키지를 지정합니다.
 * 이 설정을 통해 "org.delivery.db" 패키지 내의 리포지토리 인터페이스들을 스캔하여 JPA 리포지토리로 인식할 수 있도록 합니다.
 */
@EnableJpaRepositories(basePackages = "org.delivery.db")

public class JpaConfig {

}
