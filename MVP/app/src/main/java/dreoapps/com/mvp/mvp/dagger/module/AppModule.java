package dreoapps.com.mvp.mvp.dagger.module;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by avlad18 on 10/30/2016.
 */
@Module
public class AppModule {

    private Context mApplicationContext;

    public AppModule(Context applicationContext) {
        mApplicationContext = applicationContext;
    }


    @Provides @Singleton @ForApplication
    public Context providesApplicationContext(){
        return mApplicationContext;
    }
}
