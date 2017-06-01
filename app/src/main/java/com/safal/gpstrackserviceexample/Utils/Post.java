package com.safal.gpstrackserviceexample.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("DeviceId")
    private String DeviceId;
    @SerializedName("LatLong")
    private String LatLong;
    @SerializedName("DeviceIdentifier")
    private String DeviceIdentifier;
    @SerializedName("AdditionalData")
    private String AdditionalData;

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getLatLong() {
        return LatLong;
    }

    public void setLatLong(String latLong) {
        LatLong = latLong;
    }

    public String getDeviceIdentifier() {
        return DeviceIdentifier;
    }

    public void setDeviceIdentifier(String deviceIdentifier) {
        DeviceIdentifier = deviceIdentifier;
    }

    public String getAdditionalData() {
        return AdditionalData;
    }

    public void setAdditionalData(String additionalData) {
        AdditionalData = additionalData;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "DeviceId='" + DeviceId + '\'' +
                ", LatLong='" + LatLong + '\'' +
                ", DeviceIdentifier=" + DeviceIdentifier +
                ", AdditionalData=" + AdditionalData +
                '}';
    }
}