package com.example.demo1;

public class BikeModel {
    private String model_name;
    private String type;
    private int count_gear;

    public BikeModel(String model_name, String type, int count_gear){
        this.model_name = model_name;
        this.type = type;
        this.count_gear = count_gear;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount_gear() {
        return count_gear;
    }

    public void setCount_gear(int count_gear) {
        this.count_gear = count_gear;
    }
}
