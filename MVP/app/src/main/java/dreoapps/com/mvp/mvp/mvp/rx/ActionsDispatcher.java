package dreoapps.com.mvp.mvp.mvp.rx;

/**
 * Created by avlad18 on 10/30/2016.
 */

public interface ActionsDispatcher {
    void onError(ActionError error);
    void onNext(ActionNext response);
    void onCompleted(String ID);
}
