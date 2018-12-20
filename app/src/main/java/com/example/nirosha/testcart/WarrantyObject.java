package com.example.nirosha.testcart;


public class WarrantyObject {

    private String duration,value;
    public WarrantyObject(String duration,String value) {
        this.duration = duration;
        this.value = value;

    }

    public String getDuration() {
        return duration;
    }

    public String getValue() {
        return value;
    }
}