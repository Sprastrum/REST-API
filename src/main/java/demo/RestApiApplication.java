package demo;

import demo.repository.Connect;
import demo.repository.ProductDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		Connect.connect();
		SpringApplication.run(RestApiApplication.class, args);
		ProductDB productDB = new ProductDB();
		productDB.insertDataBase("Jabón", 1000, 20);
	}
}