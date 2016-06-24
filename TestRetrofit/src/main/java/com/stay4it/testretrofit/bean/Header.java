package com.stay4it.testretrofit.bean;


public class Header {

    private String APP_VERSION;
    private String DEVICE_UUID;
    private String DEVICE_MODEL;
    private String DEVICE_VERSION;
    private String APP_TOKEN;

    public String getAPP_VERSION() {
        return APP_VERSION;
    }

    public void setAPP_VERSION(String APP_VERSION) {
        this.APP_VERSION = APP_VERSION;
    }

    public String getDEVICE_UUID() {
        return DEVICE_UUID;
    }

    public void setDEVICE_UUID(String DEVICE_UUID) {
        this.DEVICE_UUID = DEVICE_UUID;
    }

    public String getDEVICE_MODEL() {
        return DEVICE_MODEL;
    }

    public void setDEVICE_MODEL(String DEVICE_MODEL) {
        this.DEVICE_MODEL = DEVICE_MODEL;
    }

    public String getDEVICE_VERSION() {
        return DEVICE_VERSION;
    }

    public void setDEVICE_VERSION(String DEVICE_VERSION) {
        this.DEVICE_VERSION = DEVICE_VERSION;
    }

    public String getAPP_TOKEN() {
        return APP_TOKEN;
    }

    public void setAPP_TOKEN(String APP_TOKEN) {
        this.APP_TOKEN = APP_TOKEN;
    }
}
