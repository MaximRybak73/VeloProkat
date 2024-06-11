package com.example.demo1;

public class Bike {
    private int id;
    private String model_name;
    private int order_id;

    public Bike(int id, String model_name, int order_id){
        this.id = id;
        this.model_name = model_name;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public String getModel_name() {
        return model_name;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
