package edu.utdallas.emse.hw1.serialization;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Serialized {
    String tag() default "";
}
