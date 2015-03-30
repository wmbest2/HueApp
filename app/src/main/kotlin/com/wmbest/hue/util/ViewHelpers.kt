package com.wmbest.hue.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBarActivity
import android.view.View

fun ActionBarActivity.replace(id: Int, frag: Fragment, tag: String): FragmentTransaction {
    return getSupportFragmentManager().beginTransaction()
        .replace(id, frag, tag)
}

fun Fragment.replace(id: Int, frag: Fragment, tag: String): FragmentTransaction {
    return getFragmentManager().beginTransaction()
        .replace(id, frag, tag)
}

fun View.gone() {
    this.setVisibility(View.GONE);
}

fun View.hide() {
    this.setVisibility(View.VISIBLE);
}

fun View.show() {
    this.setVisibility(View.VISIBLE);
}
