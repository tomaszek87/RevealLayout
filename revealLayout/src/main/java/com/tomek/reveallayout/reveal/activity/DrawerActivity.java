package com.tomek.reveallayout.reveal.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tomek.reveallayout.R;
import com.tomek.reveallayout.reveal.MyAdapter;
import com.tomek.reveallayout.reveal.model.SimpleModel;
import com.tomek.reveallayout.reveal.view.DividerItemDecoration;
import com.tomek.reveallayout.utils.activity.BaseActivity;
import com.tomek.reveallayout.utils.tools.CustomAnimation;

import java.util.ArrayList;

import butterknife.Bind;

public class DrawerActivity extends BaseActivity {

    @Bind(R.id.drawer)
    ImageView menu;
    @Bind(R.id.layout_to_reveal)
    LinearLayout llToReveal;
    @Bind(R.id.my_recycler_view)
    RecyclerView recyclerView;
    private boolean hidden = true;
    private MyAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CustomAnimation().toggleAnimation(llToReveal, hidden, 2);
                setHidden();
            }
        });
        prepareList();
    }

    private void prepareList() {
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new MyAdapter(getDataSet());
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private ArrayList<SimpleModel> getDataSet() {
        ArrayList results = new ArrayList<SimpleModel>();
        for (int index = 0; index < 20; index++) {
            SimpleModel obj = new SimpleModel("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }

    private void setHidden() {
        if (hidden)
            hidden = false;
        else
            hidden = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyAdapter)adapter).setOnItemClickListener(new MyAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }
        });
    }
}
