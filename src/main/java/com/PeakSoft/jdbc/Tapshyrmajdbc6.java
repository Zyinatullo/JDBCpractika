package com.PeakSoft.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tapshyrmajdbc6 {
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
        String SQL = "select count(*)from citys";
        int count = 0;
        try {
            Connection conn = connection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            {
                resultSet.next();
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static int getUsersCount1() {
        String SQL = "SELECT COUNT(*) FROM olko";
        int count = 0;
        try {
            Connection connect = connection();
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            {
                resultSet.next();
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static void addUser(String first_name, String last_name, String peoples, String president) {
        String SQL = "INSERT INTO cities(first_name,last_name,peoples,president) values(?,?,?,?)";
        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement(SQL);
            //саптык параметрлерди камтыган сурамдарды аткаруу үчүн колдонулат
            {
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, peoples);
                statement.setString(4, president);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println();
        }
    }

    public static List<cities> printUsers() {
        ArrayList<cities> list = new ArrayList<>();
        String SQL = "SELECT * FROM cities";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             // общего назначения
             ResultSet rs = stmt.executeQuery(SQL)) {
            //суроо натыйжаларын иштетүүнү жеңилдетет.
            while (rs.next()) {
                list.add(new cities(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("peoples"),
                        rs.getString("president")));

            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            return null;
        }


    }

    public static List<olko> printUsers1() {
        ArrayList<olko> list1 = new ArrayList<>();
        String SQL = "SELECT * FROM olko";
        try (Connection conn = connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next(

            )) {
                list1.add(new olko(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("area"),
                        resultSet.getString("currency"),
                        resultSet.getString("language")));
            }
            return list1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void Number(int id1) throws Exception {
        try (
            PreparedStatement preparedStatement =
                    connection().prepareStatement("SELECT* FROM cities WHERE id = (?)")){
            preparedStatement.setInt(1, id1);
            ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String first_name = rs.getString("first_name");
                    String last_name = rs.getString("last_name");
                    String peoples = rs.getString("peoples");
                    String president = rs.getString("president");
                    System.out.println(id);
                    System.out.println(first_name);
                    System.out.println(last_name);
                    System.out.println(peoples);
                    System.out.println(president);
                }

        } finally {
            connection().close();
        }
    }
}
