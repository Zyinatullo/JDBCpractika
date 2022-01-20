package com.PeakSoft.dao;

import java.sql.*;

public class Db {
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String password = "zyinatullo";


    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server\n" +
                    "successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static int getUsersCount() {
        String SQL = "select count(*)from users";
        int count = 0;
        try {
            Connection conn = connection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            {
                resultSet.next();
                count = resultSet.getInt(1);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return count;
    }
    public static void addUser(String name,int age){
        String SQL = "INSERT INTO users(name,age) values(?,?)";
        try(Connection connection = connection()){
            PreparedStatement statement = connection.prepareStatement(SQL);
            //саптык параметрлерди камтыган сурамдарды аткаруу үчүн колдонулат
            {
                statement.setString(1, name);
                statement.setInt(2, age);
                statement.executeUpdate();
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void printUsers() {
        String SQL = "SELECT * FROM users";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             // общего назначения
             ResultSet rs = stmt.executeQuery(SQL)) {
            //суроо натыйжаларын иштетүүнү жеңилдетет.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " "
                        + rs.getInt("age"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
    }
}


