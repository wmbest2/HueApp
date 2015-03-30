package com.wmbest.hue.model;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Bridge extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    @SerializedName("internalipaddress")
    private String ipAddress;

    public void setId(String id) { this.id = id; }
    public String getId() { return id; }

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; } 
    public String getIpAddress() { return ipAddress; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
}
