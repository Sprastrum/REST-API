package logic.repository;

import java.sql.*;

public class ProductDB {

    public void insertDataBase(String name, int price, int stock) {
        String sql = "INSERT INTO PRODUCT(Name, Price, Stock, Code) VALUES(?, ?, ?, null)";

        try (Connection connection = Connect.connect(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, stock);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
