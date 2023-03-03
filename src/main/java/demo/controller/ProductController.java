package demo.controller;

import demo.controller.dto.ProductDTO;
import demo.repository.ProductDB;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    static ProductDTO product = new ProductDTO();
    private ProductDB productDB = new ProductDB();

    public ProductController(List<String> products) {
    }

    @PostMapping(path = "/product/add")
    public void saveProduct(@RequestBody ProductDTO product) {
        productDB.insertDataBase(product.getName(), product.getPrice(), product.getStock());
    }

    @GetMapping("/product/update/stock")
    public void searchProduct(@RequestParam int code,
                              @RequestParam int stock) {
        productDB.update
       // if (productDB.searchDataBaseByCode(code)){

        //}


    }

}
