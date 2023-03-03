package demo.repository;

import java.sql.*;

public class ProductDB {
    private Connection connect() {
        String url = "jdbc:sqlite:.database.db";
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
    public int searchDataBaseByCode(int code) {
        String sql = "SELECT * FROM PRODUCT WHERE CODE = " + code;

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
}