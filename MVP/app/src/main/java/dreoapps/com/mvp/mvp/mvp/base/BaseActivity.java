package dreoapps.com.mvp.mvp.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by avlad18 on 10/30/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        injectDependecies();
    }


    public abstract int getLayoutID();

    public abstract void injectDependecies();

}
