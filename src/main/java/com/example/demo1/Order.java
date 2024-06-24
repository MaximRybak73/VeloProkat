package com.example.demo1;

public class Order {
    private String order_id;
    private String client_id;
    private String bike_id;
    private String shop_name;
    private String give_date;
    private String return_date;

    public Order(String client_id, String bike_id, String shop_name, String give_date, String return_date){
        this.client_id = client_id;
        this.bike_id = bike_id;
        this.shop_name = shop_name;
        this.give_date = give_date;
        this.return_date = return_date;
    }

    public Order(String order_id, String client_id, String bike_id, String shop_name, String give_date, String return_date) {
        this.order_id = order_id;
        this.client_id = client_id;
        this.bike_id = bike_id;
        this.shop_name = shop_name;
        this.give_date = give_date;
        this.return_date = return_date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getBike_id() {
        return bike_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getGive_date() {
        return give_date;
    }

    public String getReturn_date() {
        return return_date;
    }
}
