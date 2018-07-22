package com.jenu.gt.familytree.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jenu.gt.familytree.relation.core.RelationManager;

/**
 * The Annotation Relative. A class annotated as {@link Relative} will be
 * scanned at run time, and an instance will be stored in the
 * {@link RelationManager} with {@code Relative#value()} as the key.
 * 
 * @author janardhanan.s
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Relative {

	String value() default "default";

}
