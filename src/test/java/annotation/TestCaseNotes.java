package annotation;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

public @interface TestCaseNotes {

	String id() default "";

	String title();

	String[] testData() default "";

	String expectedResult() default "";

	Priority priority() default Priority.MEDIUM;

}
