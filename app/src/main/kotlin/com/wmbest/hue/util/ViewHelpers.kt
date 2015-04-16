package com.wmbest.hue.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBarActivity
import android.view.View

fun ActionBarActivity.replace(id: Int, frag: Fragment, tag: String): FragmentTransaction {
    return getSupportFragmentManager().beginTransaction()
        .replace(id, frag, tag)
}

fun ActionBarActivity.fm(body: FragmentTransaction.() -> Unit) {
    val trans = getSupportFragmentManager().beginTransaction()
    trans.body()
    trans.commit()
}

fun Fragment.replace(id: Int, frag: Fragment, tag: String): FragmentTransaction {
    return getFragmentManager().beginTransaction()
        .replace(id, frag, tag)
}

fun Fragment.fm(body: FragmentTransaction.() -> Unit) {
    val trans = getFragmentManager().beginTransaction()
    trans.body()
    trans.commit()
}

fun View.gone() {
    this.setVisibility(View.GONE);
}

fun View.hide() {
    this.setVisibility(View.INVISIBLE);
}

fun View.show() {
    this.setVisibility(View.VISIBLE);
}
