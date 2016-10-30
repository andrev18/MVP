package dreoapps.com.mvp.mvp.dagger.module;

import android.content.Context;

import com.hannesdorfmann.sqlbrite.dao.DaoManager;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dreoapps.com.mvp.mvp.MVPApplication;
import dreoapps.com.mvp.mvp.model.db.daos.EntryDao;

/**
 * Created by avlad18 on 10/30/2016.
 */

@Module
public class DBModule {

    @Inject
    Context mApplicationContext;
    private EntryDao mEntryDao;
    private DaoManager mDaoManager;

    public DBModule(Context MVPApplication) {
        mEntryDao = new EntryDao();
        mApplicationContext = MVPApplication;

        mDaoManager =DaoManager.with(mApplicationContext)
                .databaseName("MVP.db")
                .version(1)
                .add(mEntryDao)
                .logging(true)
                .build();
    }


    @Provides @Singleton
    public EntryDao provideEntryDao(){
        return mEntryDao;
    }

    @Provides @Singleton
    public Context mContext(){
        return mApplicationContext;
    }
}
