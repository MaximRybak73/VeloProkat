package com.example.demo1;

import javafx.scene.control.TableView;


import java.sql.*;

public class DataBase extends Configs {
    public static DataBase instance; //единственный экземпляр класса
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName; //jdbc - плагин кот-ый позволяет связывать джаву и базу данных

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);

        return dbConnection;
    }

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
//    private DataBase() {
//        try {
//            String connection = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
//            Class.forName("com.mysql.jdbc.Driver");
//            dbConnection = DriverManager.getConnection(connection, dbUser, dbPass);
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // Метод для получения единственного экземпляра класса
//    public static synchronized DataBase getInstance() {
//        if (instance == null) {
//            instance = new DataBase();
//        }
//        return instance;
//    }
//
//    public Connection getDbConnection() {
//        return dbConnection;
//    }


    public void writeClientInDB(Client client) throws SQLException, ClassNotFoundException { //Добавление клиента в базу данных
        String insert = "INSERT INTO " + Constants.CLIENTS_TABLE + "(" + Constants.CLIENT_NAME + "," + Constants.CLIENT_SER_PASS + "," + Constants.CLIENT_NUM_PASS + ","
                + Constants.CLIENT_ADRESS + "," + Constants.CLIENT_LOGIN + "," + Constants.CLIENT_PASSWORD + ")" + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement st = getDbConnection().prepareStatement(insert);
        st.setString(1, client.getName());
        st.setString(2, client.getSeries_pass());
        st.setString(3, client.getNum_pass());
        st.setString(4, client.getAdress());
        st.setString(5, client.getLogin());
        st.setString(6, client.getPassword());


        st.executeUpdate(); //выполнить команду
    }

    public ResultSet getClient(Client client) throws SQLException, ClassNotFoundException {  //ResultSet - будет массив из всех значений клиента(имя, сери номер паспорта, адрес и тд)

        ResultSet resultSet = null;

        String select = "SELECT " + Constants.CLIENT_ID + " FROM " + Constants.CLIENTS_TABLE + " WHERE " + Constants.CLIENT_LOGIN + "=? AND " + Constants.CLIENT_PASSWORD + "=?;";

        PreparedStatement st = getDbConnection().prepareStatement(select);
        st.setString(1, client.getLogin());
        st.setString(2, client.getPassword());

        resultSet = st.executeQuery(); //получить данные из базы данных

        return resultSet;
    }

    public ResultSet getModels() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        String select = "SELECT DISTINCT " + "bike_model." + Constants.BIKE_MODEL_MODEL_NAME +
                        " FROM " + Constants.BIKE_MODEL_TABLE +
                        " JOIN " + Constants.BIKE_TABLE + " ON bike_model." + Constants.BIKE_MODEL_MODEL_NAME + " = " + "bike." + Constants.BIKE_MODEL_NAME +
                        " LEFT JOIN " + Constants.ORDERS_TABLE + " ON bike." + Constants.BIKE_BIKE_ID + " = " + "orders." + Constants.ORDERS_BIKE_ID +
                        " WHERE " + "orders." + Constants.ORDERS_BIKE_ID + " IS NULL;"
                        ;

        PreparedStatement st = getDbConnection().prepareStatement(select);

        resultSet = st.executeQuery(); //получить данные из базы данных

        return resultSet;
    }

    public ResultSet getShops() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        String select = "SELECT " + Constants.SHOP_SHOP_NAME + " FROM " + Constants.SHOP_TABLE + " ;";

        PreparedStatement st = getDbConnection().prepareStatement(select);

        resultSet = st.executeQuery(); //получить данные из базы данных

        return resultSet;
    }

    public ResultSet getFreeBike(String selectedModel) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        String select = "SELECT " + "bike." + Constants.BIKE_BIKE_ID + " FROM " + Constants.BIKE_TABLE +
                        " LEFT JOIN " + Constants.ORDERS_TABLE + " ON " + "bike." + Constants.BIKE_BIKE_ID + " = " + "orders." + Constants.ORDERS_BIKE_ID +
                        " WHERE " + "bike." + Constants.BIKE_MODEL_NAME + " = ?" +
                        " AND " + "orders." + Constants.ORDERS_BIKE_ID + " IS NULL " +
                        "LIMIT 1;";
        PreparedStatement st = getDbConnection().prepareStatement(select);
        st.setString(1, selectedModel);
        resultSet = st.executeQuery();
        return resultSet;
    }
    public void writeOrderInDB(Order order) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Constants.ORDERS_TABLE + " (" + Constants.ORDERS_CLIENT_ID + "," + Constants.ORDERS_BIKE_ID + ","
                + Constants.ORDERS_SHOP_NAME + "," + Constants.ORDERS_GIVE_DATE + "," + Constants.ORDERS_RETURN_DATE + ")"
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = getDbConnection().prepareStatement(insert);
        st.setString(1, order.getClient_id());
        st.setString(2, order.getBike_id());
        st.setString(3, order.getShop_name());
        st.setString(4, order.getGive_date());
        st.setString(5, order.getReturn_date());
        st.executeUpdate();
    }

    public void updateClientPassword(String login, String newPassword) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + Constants.CLIENTS_TABLE +
                        " SET " + Constants.CLIENT_PASSWORD + " = ? WHERE " + Constants.CLIENT_LOGIN + " = ?";
        PreparedStatement st = getDbConnection().prepareStatement(update);
        st.setString(1, newPassword);
        st.setString(2, login);
        st.executeUpdate();
    }

    public void updateClientLogin(String newlogin, String password) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + Constants.CLIENTS_TABLE +
                " SET " + Constants.CLIENT_LOGIN + " = ? WHERE " + Constants.CLIENT_PASSWORD + " = ?";
        PreparedStatement st = getDbConnection().prepareStatement(update);
        st.setString(1, newlogin);
        st.setString(2, password);
        st.executeUpdate();
    }

    public boolean isAdmin(String login) throws SQLException, ClassNotFoundException {
        boolean isAdmin = false;
        String select = "SELECT " + Constants.CLIENT_IS_ADMIN + " FROM " + Constants.CLIENTS_TABLE +
                        " WHERE " + Constants.CLIENT_LOGIN + " =?";
        PreparedStatement st = getDbConnection().prepareStatement(select);
        st.setString(1, login);
        ResultSet resultSet = st.executeQuery();
        if(resultSet.next()){
            isAdmin = resultSet.getBoolean("is_admin");
        }
        return isAdmin;
    }

    public ResultSet isBusyLogin(String login) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;

        String select = "SELECT " + Constants.CLIENT_ID +
                        " FROM " + Constants.CLIENTS_TABLE +
                        " WHERE " + Constants.CLIENT_LOGIN + " = ?;";

        PreparedStatement st = getDbConnection().prepareStatement(select);
        st.setString(1, login);

        resultSet = st.executeQuery(); //получить данные из базы данных

        return resultSet;
    }

    public void loadOrdersFromDB(TableView<Order> ordersTable) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM orders";
        PreparedStatement st = getDbConnection().prepareStatement(select);

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()){
            String order_id = resultSet.getString("order_id");
            String client_id = resultSet.getString("client_id");
            String bike_id = resultSet.getString("bike_id");
            String shop_name = resultSet.getString("shop_name");
            String give_date = resultSet.getString("give_date");
            String return_date = resultSet.getString("return_date");

            Order order = new Order(order_id, client_id, bike_id, shop_name, give_date, return_date);
            ordersTable.getItems().add(order);
        }
    }

    public void deleteCurrentOrder(String order_id) throws SQLException, ClassNotFoundException {
        String select = "DELETE FROM " + Constants.ORDERS_TABLE +
                " WHERE " + Constants.ORDERS_ORDER_ID + " = ?;";
        PreparedStatement st = getDbConnection().prepareStatement(select);
        st.setString(1, order_id);
        st.executeUpdate();
    }
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


