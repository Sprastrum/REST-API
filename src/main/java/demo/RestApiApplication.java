package demo;

import demo.repository.Connect;
import demo.repository.ProductDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> stocks = new ArrayList<>();

		names.add("Jabón");
		names.add("Queso");

		stocks.add(562);
		stocks.add(2);

		SpringApplication.run(RestApiApplication.class, args);
		ProductDB productDB = new ProductDB();
		productDB.sellProduct(names, stocks);
	}
}