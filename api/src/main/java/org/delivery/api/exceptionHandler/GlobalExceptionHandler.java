package org.delivery.api.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.ErrorCodeInterface;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE) // 가장 마지막에 실행 적용 (값이 낮을수록 먼저 실행된다)
public class GlobalExceptionHandler {

    // 어짜피 커스텀한 예외는 앞에서 다 잡아줄 것이므로 여기서는 우리가 예상치 못한 예외를 잡아주는 것을 목표로 한다.
    @ExceptionHandler
    public ResponseEntity<Api<Object>> exception(
        Exception exception
    ){
        log.error("", exception);

        return ResponseEntity
                .status(500)
                .body(
                    Api.ERROR(ErrorCode.SERVER_ERROR)
                );
    }
}
