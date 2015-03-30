package com.wmbest.hue.util

fun Any.d(log: String) {
    android.util.Log.d(this.javaClass.getName(), log) 
}

fun Any.d() {
    this.d(this.toString()) 
}
