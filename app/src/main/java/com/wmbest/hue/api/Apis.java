package com.wmbest.hue.api;

import retrofit.*;
import retrofit.android.*;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.util.*;

import io.realm.RealmObject;

public class Apis {
    private static Apis sInstance = null;

    Apis() { 
        mMeetHue = mRestAdapter.create(MeetHueApi.class);
    }

    public static Apis getInstance() {
        if (sInstance == null) {
            sInstance = new Apis();
        }

        return sInstance;
    }

    public static final Gson GSON = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        })
        .create();

    private RestAdapter mRestAdapter = new RestAdapter.Builder()
        .setEndpoint("http://www.meethue.com/api")
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setLog(new AndroidLog("=NETWORK="))
        .setConverter(new GsonConverter(GSON))
        .build();

    private MeetHueApi mMeetHue;
    
    public MeetHueApi meetHue() {
        return mMeetHue;
    }
}
