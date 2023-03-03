package demo.repository;

import java.beans.PropertyEditorSupport;
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

    public void update(int stock, int code) {
        String sql = "UPDATE PRODUCT "+"SET STOCK = ? WHERE CODE = ?";

        try (Connection connection = this.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, stock);
            statement.setInt(2, code);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int searchDataBaseByCode(int code) {
        String sql = "SELECT * FROM PRODUCT WHERE CODE = " + code;
        int result = 0;

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t" +
                        rs.getInt("Price") + "\t" +
                        rs.getInt("Stock") + "\t" +
                        rs.getInt("Code"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public Integer sellProduct(ArrayList<String> names, ArrayList<Integer> stocks) {
        int result = 0;

        for(String s: names) {
            String sql = "SELECT PRICE FROM PRODUCT WHERE CODE = " + s;

            try (Connection connection = this.connect();
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.println(rs.getString("Name") + "\t" +
                            rs.getInt("Price") + "\t" +
                            rs.getInt("Stock") + "\t" +
                            rs.getInt("Code"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}