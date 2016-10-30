package dreoapps.com.mvp.mvp.model.db.daos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.hannesdorfmann.sqlbrite.dao.Dao;

import java.util.List;

import dreoapps.com.mvp.mvp.model.db.Tables;
import dreoapps.com.mvp.mvp.model.model.Entry;
import dreoapps.com.mvp.mvp.model.model.EntryMapper;
import rx.Observable;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class EntryDao extends Dao {
    @Override
    public void createTable(SQLiteDatabase database) {
        CREATE_TABLE(Tables.Entry.TABLE_NAME,
                Tables.Entry.COL_NAME+" TEXT")
                .execute(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Observable<List<Entry>> getEntries(){
        return query(SELECT(Tables.Entry.COL_NAME)
        .FROM(Tables.Entry.TABLE_NAME))
                .run().mapToList(EntryMapper.MAPPER);
    }


    public Observable<Long> insert(int id,String name){
        ContentValues values = EntryMapper.contentValues()
                .name(name)
                .build();
        return insert(Tables.Entry.TABLE_NAME,values);
    }
}
