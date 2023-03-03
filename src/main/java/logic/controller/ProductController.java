package logic.controller;
import logic.controller.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
