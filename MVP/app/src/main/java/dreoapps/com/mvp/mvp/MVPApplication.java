package dreoapps.com.mvp.mvp;

import android.app.Application;

import dreoapps.com.mvp.mvp.dagger.module.DBComponent;
import dreoapps.com.mvp.mvp.dagger.module.DBModule;
import dreoapps.com.mvp.mvp.dagger.module.DaggerDBComponent;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class MVPApplication extends Application {


    private static DBComponent mDBComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mDBComponent = DaggerDBComponent.builder()
                .dBModule(new DBModule(this)).build();
    }

    public static DBComponent getDBComponent(){
        return mDBComponent;
    }
}
