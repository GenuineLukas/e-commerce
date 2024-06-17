package org.delivery.api.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.user.enums.UserStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    // db에 저장된 인덱스 id
    private Long id;

    private String name;

    private String email;

    // 패스워드는 보여주면 안되니까 빼고

    private UserStatus status;

    private String address;

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
