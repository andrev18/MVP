package dreoapps.com.mvp.mvp.model.model;

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

import dreoapps.com.mvp.mvp.model.db.Tables;

/**
 * Created by avlad18 on 10/30/2016.
 */

@ObjectMappable
public class Entry {
    @Column(Tables.Entry.COL_NAME) private String name;

    public Entry(){}
    public Entry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
