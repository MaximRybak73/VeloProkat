package com.example.demo1;

public class Client {
    private String name;
    private String series_pass;
    private String num_pass;
    private String adress;
    private String login;
    private String password;

    public Client(String name, String series_pass, String num_pass, String adress, String login, String password){
        this.name = name;
        this.series_pass = series_pass;
        this.num_pass = num_pass;
        this.adress = adress;
        this.login = login;
        this.password = password;
    }

    public Client(String name, String series_pass, String num_pass, String adress){
        this.name = name;
        this.series_pass = series_pass;
        this.num_pass = num_pass;
        this.adress = adress;
    }


    public Client() {

    }

    public String getName(){
        return name;
    }

    public String getSeries_pass(){
        return series_pass;
    }

    public String getNum_pass(){
        return num_pass;
    }

    public String getAdress(){
        return adress;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
