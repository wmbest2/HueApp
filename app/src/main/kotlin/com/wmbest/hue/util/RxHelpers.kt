package com.wmbest.hue.util

import android.app.Activity
import android.support.v4.app.Fragment

import rx.android.app.AppObservable
import rx.Observable

fun <T, R: Array<T>> Observable<R>.toItems(): Observable<T> { 
    return this.map({it.toList()}).flatMapIterable({it}) 
}

fun <T> Activity.bind(observable: Observable<T>): Observable<T> {
    return AppObservable.bindActivity(this, observable)
}

fun <T> Fragment.bind(observable: Observable<T>): Observable<T> {
    return AppObservable.bindFragment(this, observable)
}
