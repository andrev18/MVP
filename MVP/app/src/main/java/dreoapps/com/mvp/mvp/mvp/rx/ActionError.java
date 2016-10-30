package dreoapps.com.mvp.mvp.mvp.rx;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class ActionError {
    private final String mID;
    private final Throwable mThrowable;


    public ActionError(String ID, Throwable throwable) {
        mID = ID;
        mThrowable = throwable;
    }


    public String getID() {
        return mID;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }
}
