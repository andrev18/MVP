package dreoapps.com.mvp.mvp.mvp.base;

/**
 * Created by avlad18 on 10/30/2016.
 */

public final class BaseContract {
    private BaseContract(){};
    public interface Presenter<T extends View> {

        void bind(T view);
        void unbind();
    }

    public interface View {
    }

}
