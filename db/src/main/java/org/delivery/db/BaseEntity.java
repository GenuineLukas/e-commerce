package org.delivery.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * BaseEntity 클래스
 *
 * 이 클래스는 JPA 엔티티 클래스들의 공통 매핑 정보를 제공하는 슈퍼클래스입니다.
 * 이 클래스를 상속하는 엔티티 클래스들은 이 클래스의 필드들을 상속받아 사용할 수 있습니다.
 */

@MappedSuperclass
/**
 * @MappedSuperclass:
 * 이 클래스가 JPA 엔티티 클래스들의 공통 매핑 정보를 제공하는 슈퍼클래스임을 나타냅니다.
 * 이 클래스를 상속하는 엔티티 클래스들은 이 클래스의 필드들을 상속받아 사용할 수 있습니다.
 */
@Data
/**
 * @Data:
 * Lombok 라이브러리를 사용하여 자동으로 getter, setter, toString, equals, hashCode 메서드를 생성해줍니다.
 */
@SuperBuilder
/**
 * @SuperBuilder:
 * Lombok의 @Builder 어노테이션을 확장하여 상속받은 클래스에서도 빌더 패턴을 사용할 수 있도록 합니다.
 */
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    /**
     * 기본 키 (Primary Key) 필드
     *
     * 이 필드는 엔티티의 기본 키로 사용됩니다.
     */

    @Id
    /**
     * @Id:
     * 이 필드가 엔티티의 기본 키임을 나타냅니다.
     */

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * @GeneratedValue:
     * 기본 키 값을 자동으로 생성해주는 전략을 설정합니다.
     * GenerationType.IDENTITY는 데이터베이스의 자동 증가 컬럼(AUTO_INCREMENT)을 사용하여 기본 키를 생성합니다.
     */
    private Long id;
}
