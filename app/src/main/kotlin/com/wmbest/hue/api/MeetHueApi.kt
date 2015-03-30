package com.wmbest.hue.api

import retrofit.http.GET

import rx.Observable

import com.wmbest.hue.model.Bridge

trait MeetHueApi {
    GET("/nupnp") 
    fun bridges(): Observable<Array<Bridge>>
}
