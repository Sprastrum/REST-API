package demo.repository;

import java.sql.*;
import java.util.ArrayList;

public class ProductDB {
    private Connection connect() {
        String url = "jdbc:sqlite:database.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void insertDataBase(String name, int price, int stock) {
        String sql = "INSERT INTO PRODUCT(Name, Price, Stock, Code) VALUES(?, ?, ?, null)";

        try (Connection connection = this.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, stock);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int code, int stock) {
        String sql = "UPDATE PRODUCT " +
                "SET STOCK = ? WHERE CODE = " + code;

        try (Connection connection = this.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, code);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String searchDataBaseByName(String name) {
        String sql = "SELECT * FROM PRODUCT WHERE CODE = \"" + name + "\"";
        String result = "";

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                result = (rs.getString("Name") + "\t" +
                        rs.getInt("Price") + "\t" +
                        rs.getInt("Stock") + "\t" +
                        rs.getInt("Code"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int actuallyStock(String name) {
        String sql = "SELECT STOCK FROM PRODUCT WHERE CODE = \"" + name + "\"";
        int result = 0;

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                result = rs.getInt("Stock");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public boolean inStocks(String name, int stock) {
        String sql = "SELECT STOCK FROM PRODUCT WHERE NAME = \"" + name + "\"";
        boolean result = true;

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            if(stock > rs.getInt("Stock")) {
                System.out.println("No hay tanta cantidad de " + name + " para vender.");
                result = false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public Integer sellProduct(ArrayList<String> names, ArrayList<Integer> stocks) {
        int result = 0;
        int index = 0;

        for(String s: names) {
            String sql = "SELECT PRICE, STOCK, CODE FROM PRODUCT WHERE NAME = \"" + s + "\"";

            if(inStocks(s, stocks.get(index))) {
                try (Connection connection = this.connect();
                     Statement statement = connection.createStatement();
                     ResultSet rs = statement.executeQuery(sql)) {

                    while (rs.next()) {
                        result += rs.getInt("Price") * stocks.get(index);

                        System.out.println(result);
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            index ++;
        }

        return result;
    }
}