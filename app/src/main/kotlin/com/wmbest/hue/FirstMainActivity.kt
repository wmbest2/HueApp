package com.wmbest.hue

import android.os.Bundle
import android.support.v7.app.ActionBarActivity

import kotlinx.android.synthetic.activity_main.*

import com.wmbest.hue.fragments.*
import com.wmbest.hue.util.*

import com.wmbest.traits.Animal;
import com.wmbest.traits.Duck;
import com.wmbest.traits.Swimmer;

class FirstMainActivity : ActionBarActivity() {

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (state == null) {
            replace(R.id.container, BridgeSetupFragment(), "setup")
                .commit()
        }
    } 
} 
