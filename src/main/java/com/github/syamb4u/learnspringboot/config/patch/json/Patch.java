package com.github.syamb4u.learnspringboot.config.patch.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Created by socrates on 7/20/16.
 * 
 * https://github.com/countrogue/spring-http-patch-example
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Patch {
    Class service();

    Class id();
}
