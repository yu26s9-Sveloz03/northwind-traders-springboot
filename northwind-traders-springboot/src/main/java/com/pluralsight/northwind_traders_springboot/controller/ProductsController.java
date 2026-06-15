package com.pluralsight.northwind_traders_springboot.controller;

/*Create a ProductsController class in your controller package.
The controller should:
• Be set up as a REST controller with a base path of /api/products
• Inject the ProductService through the constructor
• Include the following endpoints:

 Verb - Path - What it does - Returns
 GET - /api/products - get all products - list of products
 GET - /api/products/{id} - get a product by ID - Product or 404
 POST - /api/prodcuts - add a new product - The saved product
 DELETE - /api/products/{id} - delete a product by id - 204 No Content*/


import com.pluralsight.northwind_traders_springboot.model.Product;
import com.pluralsight.northwind_traders_springboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }


}
