package demo.controller;

import demo.controller.dto.ProductDTO;
import demo.repository.ProductDB;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    static ProductDTO product = new ProductDTO();
    private ProductDB productDB = new ProductDB();

    public ProductController(List<String> products) {
    }

    @PostMapping(path = "/product")
    public void saveProduct(@RequestBody ProductDTO product) {
        productDB.insertDataBase(product.getName(), product.getPrice(), product.getStock());
    }


}
