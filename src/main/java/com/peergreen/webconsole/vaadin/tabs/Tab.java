package com.peergreen.webconsole.vaadin.tabs;

import com.peergreen.webconsole.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mohammed Boukada
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Qualifier("tab")
public @interface Tab {
    String value();
    String imgPath() default "";
}
