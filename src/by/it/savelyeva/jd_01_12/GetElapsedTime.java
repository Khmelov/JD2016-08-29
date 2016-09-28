package by.it.savelyeva.jd_01_12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nato on 9/28/16.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * Annotation is considered to be applied to methods we need to see how much time their execution takes.
 */
public @interface GetElapsedTime {
    String description() default "";
}
