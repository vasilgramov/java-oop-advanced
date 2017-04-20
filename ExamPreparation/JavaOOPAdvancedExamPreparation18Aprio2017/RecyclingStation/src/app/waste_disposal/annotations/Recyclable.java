package app.waste_disposal.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by vladix on 4/19/17.
 */

@Disposable
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Recyclable {
}
