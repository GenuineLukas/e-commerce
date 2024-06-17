package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies that the annotated type is a business service, to be automatically
 * registered as a Spring bean.
 *
 * @Retention defines how long the annotation should be retained. In this case,
 * it is retained at runtime, making it available for reflection at runtime.
 *
 * @Target specifies that this annotation can only be applied to types (classes, interfaces, etc.).
 *
 * @Service indicates that the annotated class is a service in the Spring context.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Service
public @interface Business {
    @AliasFor(annotation = Service.class)
    String value() default "";
}
