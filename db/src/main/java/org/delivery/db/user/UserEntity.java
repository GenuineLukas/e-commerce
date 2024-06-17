package org.delivery.db.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.user.enums.UserStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents a user entity in the system.
 * Extends the BaseEntity class to include common entity fields.
 */
@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {

    /**
     * The name of the user.
     */
    @Column(length = 50, nullable = false)
    private String name;

    /**
     * The email of the user. Must be unique.
     */
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    /**
     * The password of the user.
     */
    @Column(length = 100, nullable = false)
    private String password;

    /**
     * The status of the user, represented as an enum.
     */
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private UserStatus status;

    /**
     * The address of the user.
     */
    @Column(length = 150, nullable = false)
    private String address;

    /**
     * The timestamp when the user was registered.
     */
    @Column(nullable = false)
    private LocalDateTime registeredAt;

    /**
     * The timestamp when the user was unregistered.
     */
    private LocalDateTime unregisteredAt;

    /**
     * The timestamp when the user last logged in.
     */
    private LocalDateTime lastLoginAt;
}
