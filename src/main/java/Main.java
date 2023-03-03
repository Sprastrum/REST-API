import logic.repository.ProductDB;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductDB productDB = new ProductDB();
        productDB.insertDataBase("Jabón", 1000, 20);
        productDB.searchDataBaseByCode(1);
    }
}
