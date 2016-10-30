package dreoapps.com.mvp.mvp.screens;

import android.widget.ArrayAdapter;

import dreoapps.com.mvp.mvp.mvp.base.BaseContract;

/**
 * Created by avlad18 on 10/30/2016.
 */

public final class MainContract {

    public interface MainView extends BaseContract.View{
        void setupEntriesList(ArrayAdapter<String> adapter);
    }

    public interface MainPresenter extends BaseContract.Presenter<MainView>{
        void loadEntries();
        void updateEntryList(String entry);
    }
}
