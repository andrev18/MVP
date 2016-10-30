package dreoapps.com.mvp.mvp.screens;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dreoapps.com.mvp.mvp.MVPApplication;
import dreoapps.com.mvp.mvp.dagger.module.DaggerDBComponent;
import dreoapps.com.mvp.mvp.model.db.daos.EntryDao;
import dreoapps.com.mvp.mvp.model.model.Entry;
import dreoapps.com.mvp.mvp.mvp.base.BasePresenter;
import dreoapps.com.mvp.mvp.mvp.rx.ActionError;
import dreoapps.com.mvp.mvp.mvp.rx.ActionNext;
import dreoapps.com.mvp.mvp.mvp.rx.ActionSubscriber;
import dreoapps.com.mvp.mvp.mvp.rx.Actions;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {

    ArrayAdapter<String> mAdapter;
    ArrayList<String> entries;


    @Inject
    EntryDao mEntryDao;

    @Inject
    Context mContext;


    @Override
    public void onError(ActionError error) {

    }

    @Override
    public void onNext(ActionNext response) {

        switch (response.getID()){
            case Actions.ActionsMain.GET_ENTRIES:
                ArrayList<String> entries = (ArrayList<String>) Observable.from((List<Entry>)response.getObject()).map(new Func1<Entry, String>() {
                    @Override
                    public String call(Entry entry) {
                        return entry.getName();
                    }
                }).toList().toBlocking().single();
                mAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, entries);
                getiView().setupEntriesList(mAdapter);
                break;

            case Actions.ActionsMain.UPDATE_ENTRY:
                loadEntries();
            default:
                break;
        }

    }

    @Override
    public void onCompleted(String ID) {

    }

    @Override
    public void loadEntries() {
        mEntryDao.getEntries().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new ActionSubscriber<List<Entry>>(this,Actions.ActionsMain.GET_ENTRIES));
    }

    @Override
    public void updateEntryList(String entry) {
        mEntryDao.insert(0,entry).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new ActionSubscriber<Long>(this,Actions.ActionsMain.UPDATE_ENTRY));
    }


    @Override
    public void injectDependencies() {
        MVPApplication.getDBComponent().inject(this);
    }
}
