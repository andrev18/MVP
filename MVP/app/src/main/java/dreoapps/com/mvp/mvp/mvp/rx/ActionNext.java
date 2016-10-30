package dreoapps.com.mvp.mvp.mvp.rx;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class ActionNext {
    private final String mID;
    private final Object mObject;

    public ActionNext(String ID, Object object) {
        mID = ID;
        mObject = object;
    }

    public String getID() {
        return mID;
    }

    public Object getObject() {
        return mObject;
    }
}
