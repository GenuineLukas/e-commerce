package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter //인터페이스를 implements 해도 구현체를 직접 생성하지 않고 이 경우에는 이 어노테이션으로 해결가능
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeInterface {
    OK(200, 200, "성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "잘못된 요청"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "서버 에러"),
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "NUll Point")
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
