package com.gy.annotation;

import java.lang.annotation.*;

/**
 * TestAnnotation的集合类
 */
@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestAnnotations {
    TestAnnotation[] value();
}
