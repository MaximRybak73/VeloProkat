package com.example.demo1;

public class Bike {
    private int id;
    private String model_name;

    public Bike(int id, String model_name, int order_id){
        this.id = id;
        this.model_name = model_name;
    }

    public int getId() {
        return id;
    }

    public String getModel_name() {
        return model_name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }
}
