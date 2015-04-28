package pl.net.nowak.core.annotations;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * Author: Maciek
 */

/**
 * specify which Java elements your custom annotation can be used to annotate.
 */
@Target({ElementType.TYPE})
/**
 *  signals to the compiler and JVM that the annotation should be available via reflection at runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * signal to the JavaDoc tool that your custom annotation should be visible in the JavaDoc for classes using your custom annotation
 */
@Documented
@Controller
public @interface RestAPI {
}
