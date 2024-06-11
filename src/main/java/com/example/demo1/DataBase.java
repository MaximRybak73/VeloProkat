package com.example.demo1;

import java.sql.*;
public class DataBase extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; //jdbc - плагин кот-ый позволяет связывать джаву и базу данных

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);

        return  dbConnection;
    }

    public void writeClientInDB(String name, String series_pass, String num_pass, String adress, String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Constants.CLIENTS_TABLE + "(" + Constants.CLIENT_NAME + "," + Constants.CLIENT_SER_PASS + "," + Constants.CLIENT_NUM_PASS + ","
                + Constants.CLIENT_ADRESS+ "," + Constants.CLIENT_LOGIN + "," + Constants.CLIENT_PASSWORD + ")" + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement st = getDbConnection().prepareStatement(insert);
        st.setString(1, name);
        st.setString(2, series_pass);
        st.setString(3, num_pass);
        st.setString(4, adress);
        st.setString(5, login);
        st.setString(6, password);


        st.executeUpdate(); //выполнить команду
    }






























//    Connection connection;
//    public void test() {
//        try {
//            String url = "jdbc:mysql://localhost/bike_orders";
//            String username = "root";
//            String password = "12345";
//            connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String query = "SELECT * from clients";
//            ResultSet result = statement.executeQuery(query);
//
//            while (result.next()) {
//                String id = result.getString("client_id");
//                String name = result.getString("name");
//                String ser_pass = result.getString("series_pass");
//                String num_pass = result.getString("num_pass");
//                String adress = result.getString("client_adress");
//                System.out.println(id +", " + name + ", " + ser_pass + ", " +  num_pass + ", " + adress);
//            }
//            connection.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void regClient(Client client) throws SQLException {
//        String insert = "INSERT INTO clients(name, series_pass, num_pass, client_adress)VALUES(?, ?, ?, ?)";
//        PreparedStatement st = dbConnection.prepareStatement(insert);
//        st.setString(1, client.getName());
//        st.setString(2, client.getSeries_pass());
//        st.setString(3, client.getNum_pass());
//        st.setString(4, client.getAdress());
//
//        st.executeUpdate();
//    }
}
