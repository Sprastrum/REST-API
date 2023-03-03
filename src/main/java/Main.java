import logic.repository.ProductDB;

import java.sql.SQLException;

import static logic.repository.Connect.connect;

public class Main {
    public static void main(String[] args) throws SQLException {
        connect();
        ProductDB productDB = new ProductDB();
        productDB.insertDataBase("Jabón", 1000, 20);
    }
}
