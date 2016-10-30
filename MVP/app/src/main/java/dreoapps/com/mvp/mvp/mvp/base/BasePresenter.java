package dreoapps.com.mvp.mvp.mvp.base;

import dreoapps.com.mvp.mvp.mvp.rx.ActionsDispatcher;

/**
 * Created by avlad18 on 10/29/2016.
 */

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T>,ActionsDispatcher {



    private T iView;


    @Override
    public void bind(T view) {
        iView = view;
        injectDependencies();
    }

    @Override
    public void unbind() {
        iView = null;
    }


    public abstract void injectDependencies();

    public T getiView() {
        return iView;
    }
}
