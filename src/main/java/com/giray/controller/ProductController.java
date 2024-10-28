package com.giray.controller;
import com.giray.entity.Product;
import com.giray.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.giray.constants.RestApiUrls.*;


@RestController
@RequestMapping(PRODUCT)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }


    @PostMapping(CREATE)
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }


    @DeleteMapping(DELETE_BY_ID + "/{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productService.deleteProductById(id);
    }

    @GetMapping(GET_ALL)
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PutMapping(UPDATE + "/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }






}
