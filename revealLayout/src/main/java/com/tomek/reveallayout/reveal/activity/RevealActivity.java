package com.tomek.reveallayout.reveal.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.tomek.reveallayout.R;
import com.tomek.reveallayout.utils.activity.BaseActivity;
import com.tomek.reveallayout.utils.tools.CustomAnimation;

import butterknife.Bind;

public class RevealActivity extends BaseActivity {

    @Bind(R.id.layout_to_reveal)
    LinearLayout llToReveal;
    private boolean hidden = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CustomAnimation().toggleAnimation(llToReveal, hidden, 0);
                setHidden();
            }
        });
//        ViewTreeObserver observer = findViewById(android.R.id.content).getViewTreeObserver();
//
//        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//
//            @Override
//            public void onGlobalLayout() {
//                findViewById(android.R.id.content).getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                prepareAnimation(llToReveal);
//            }
//        });
    }

    private void setHidden() {
        if(hidden)
            hidden = false;
        else
            hidden = true;

    }


    private void init() {
        llToReveal.setVisibility(View.INVISIBLE);
    }

}
