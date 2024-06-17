package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for marking converter service classes.
 *
 * This annotation is a specialization of {@link Service}, indicating that
 * an annotated class is a "UserConverter Service".
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface Converter {
    /**
     * Alias for the {@link Service#value()} attribute, allowing
     * the specification of a suggested component name.
     *
     * @return the suggested component name, if any (or empty string otherwise)
     */
    @AliasFor(annotation = Service.class)
    String value() default "";
}
