package demo.controller;

import demo.controller.dto.ProductDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    static List<ProductDTO> products = new ArrayList<>();


    public ProductController(List<String> products) {
    }

    @PostMapping(path = "/product")
    public void saveProduct(@RequestBody ProductDTO product) {
        products.add(product);
    }

}
