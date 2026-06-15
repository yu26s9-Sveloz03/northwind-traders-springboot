package com.pluralsight.northwind_traders_springboot.service;

/*Create a ProductService class in your service package.
The service should:
• Inject the ProductRepository through the constructor
• Be annotated so Spring recognizes it as a bean
• Include methods for the following operations:
o Get all products
o Get a product by ID (think about what happens if the product doesn't exist)
o Add a new product
o Delete a product by ID */

import com.pluralsight.northwind_traders_springboot.model.Product;
import com.pluralsight.northwind_traders_springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
