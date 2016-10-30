package dreoapps.com.mvp.mvp.mvp.rx;

import rx.Subscriber;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class ActionSubscriber<T> extends Subscriber<T> {
    private final ActionsDispatcher mActionsDispatcher;
    private final String mID;


    public ActionSubscriber(ActionsDispatcher actionsDispatcher, String ID) {
        mActionsDispatcher = actionsDispatcher;
        mID = ID;
    }

    @Override
    public void onCompleted() {
        mActionsDispatcher.onCompleted(mID);
    }

    @Override
    public void onError(Throwable e) {
        mActionsDispatcher.onError(new ActionError(mID,e));

    }

    @Override
    public void onNext(T t) {
        mActionsDispatcher.onNext(new ActionNext(mID,t));

    }
}
