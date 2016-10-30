package dreoapps.com.mvp.mvp.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dreoapps.com.mvp.R;
import dreoapps.com.mvp.mvp.model.model.Entry;
import dreoapps.com.mvp.mvp.mvp.base.BaseActivity;
import dreoapps.com.mvp.mvp.dagger.module.DBModule;
import dreoapps.com.mvp.mvp.dagger.module.DaggerDBComponent;
import dreoapps.com.mvp.mvp.model.db.daos.EntryDao;
import rx.Subscriber;

/**
 * Created by avlad18 on 10/30/2016.
 */

public class MainActivity extends BaseActivity implements MainContract.MainView{


    private EditText entry_name;
    private Button btn_enter;
    private ListView entriesList;
    private MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        entry_name = (EditText) findViewById(R.id.et_entry_name);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        entriesList = (ListView) findViewById(R.id.entries);
        presenter = new MainPresenter();
        presenter.bind(this);
        presenter.loadEntries();

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateEntryList(entry_name.getEditableText().toString());
            }
        });

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void injectDependecies() {

    }



    @Override
    public void setupEntriesList(ArrayAdapter<String> adapter) {
        entriesList.setAdapter(adapter);
    }


    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
