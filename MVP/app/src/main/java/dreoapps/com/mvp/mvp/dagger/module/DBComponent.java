package dreoapps.com.mvp.mvp.dagger.module;

import javax.inject.Singleton;

import dagger.Component;
import dreoapps.com.mvp.mvp.screens.MainActivity;
import dreoapps.com.mvp.mvp.screens.MainPresenter;

/**
 * Created by avlad18 on 10/30/2016.
 */

@Singleton
@Component(modules = DBModule.class)
public interface DBComponent {
    void inject(MainPresenter presenter);
    void inject(MainActivity mainActivity);
}
