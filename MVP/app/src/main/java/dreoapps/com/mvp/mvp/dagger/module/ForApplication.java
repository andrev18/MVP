package dreoapps.com.mvp.mvp.dagger.module;

/**
 * Created by avlad18 on 10/30/2016.
 */

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

@Qualifier @Retention(RUNTIME)
public @interface ForApplication {
}
