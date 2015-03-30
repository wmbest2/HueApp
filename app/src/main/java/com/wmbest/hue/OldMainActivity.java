package com.wmbest.hue;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import butterknife.*;

import com.wmbest.hue.fragments.*;

public class OldMainActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new BridgeSetupFragment(), "setup")
                .commit(); 
        }
    } 
} 
