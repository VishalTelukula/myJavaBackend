package com.learning.SimplewebApp.services;

import com.learning.SimplewebApp.model.Product;
import com.learning.SimplewebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products =new ArrayList<>(Arrays.asList(
//            new Product(1,"iphone",20000),
//            new Product(2,"oneplus",10000),
//            new Product(3,"Sony",100000)));
    // here we created a example repositorry of the products as we are not dealing with the backend yet
    // return type is list as we return list of products
    public List<Product> getproducts(){
        return repo.findAll();
    }

    public Product getProductbyId(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);

    }
}
