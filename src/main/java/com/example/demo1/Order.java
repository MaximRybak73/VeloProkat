package com.example.demo1;

public class Order {
    private int order_id;
    private int client_id;
    private int bike_id;
    private String shop_name;
    private int give_date;
    private int return_date;

    public Order(int order_id, int client_id, int bike_id, String shop_name, int give_date, int return_date){
        this.order_id = order_id;
        this.client_id = client_id;
        this.bike_id = bike_id;
        this.shop_name = shop_name;
        this.give_date = give_date;
        this.return_date = return_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getGive_date() {
        return give_date;
    }

    public void setGive_date(int give_date) {
        this.give_date = give_date;
    }

    public int getReturn_date() {
        return return_date;
    }

    public void setReturn_date(int return_date) {
        this.return_date = return_date;
    }
}
