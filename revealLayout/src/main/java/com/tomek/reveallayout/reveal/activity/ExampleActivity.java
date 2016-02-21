package com.tomek.reveallayout.reveal.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tomek.reveallayout.R;
import com.tomek.reveallayout.utils.activity.BaseActivity;
import com.tomek.reveallayout.utils.tools.CustomAnimation;

import butterknife.Bind;

public class ExampleActivity extends BaseActivity {

    @Bind(R.id.layout_to_reveal)
    LinearLayout llToReveal;
    @Bind(R.id.layout_to_reveal2)
    LinearLayout llToReveal2;
    @Bind(R.id.search)
    ImageView searchImage;
    @Bind(R.id.cancel)
    ImageView cancel;
    private boolean hidden = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchImage.setVisibility(View.INVISIBLE);
                new CustomAnimation().toggleAnimation(llToReveal, hidden, 1);
                setHidden();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchImage.setVisibility(View.VISIBLE);
                new CustomAnimation().toggleAnimation(llToReveal, hidden, 1);
                setHidden();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CustomAnimation().toggleAnimation(llToReveal2, hidden, 0);
                setHidden();
            }
        });
    }

    private void setHidden() {
        if (hidden)
            hidden = false;
        else
            hidden = true;

    }

    private void init() {
        llToReveal.setVisibility(View.INVISIBLE);
    }

}
