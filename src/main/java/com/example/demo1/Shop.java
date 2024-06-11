package com.example.demo1;

public class Shop {
    private String shop_name;
    private String shop_adress;

    public Shop(String shop_name, String shop_adress){
        this.shop_name = shop_name;
        this.shop_adress = shop_adress;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_adress() {
        return shop_adress;
    }

    public void setShop_adress(String shop_adress) {
        this.shop_adress = shop_adress;
    }
}
