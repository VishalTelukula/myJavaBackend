package com.learning.SimplewebApp.controller;

import com.learning.SimplewebApp.model.Product;
import com.learning.SimplewebApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProducctController {
    @Autowired

    ProductService Service;
    @RequestMapping("/products")
    public List<Product> getProduct(){
        return Service.getproducts();
    }
    @RequestMapping("/products/{prodId}")
    public Product getProductbyId(@PathVariable int prodId){
        return Service.getProductbyId(prodId);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod);
        Service.addProduct(prod);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        Service.updateProduct(prod);
    }
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        Service.deleteProduct(prodId);
    }
}
