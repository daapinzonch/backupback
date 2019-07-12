package com.redcampo.app.Controller;

import com.redcampo.app.Entity.Product;
import com.redcampo.app.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apiproduct")
public class ProductController {
    private final ProductService prCon;

    @GetMapping()
    public String msg(){
        return "PRODUCTS AVAIABLE";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(prCon.findAll());
    }

    @PostMapping(path ="/insertdata", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody Product product) {
        List<Product> users = prCon.findByProductId(product.getProductId());
        if (users.isEmpty()){
            prCon.create(product);
            return new ResponseEntity<>("PRODUCT CREATED", HttpStatus.ACCEPTED);
        }else {
            Product empty = new Product();
            return new ResponseEntity<>("PRODUCT DUPLICATED", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deletedata/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        List<Product> products = prCon.findByProductId(id);
        if(!products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                prCon.delete(products.get(i));
            }
            return new ResponseEntity<>("PRODUCT DELETED", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("PRODUCT EMPTY", HttpStatus.BAD_REQUEST);
        }
    }
}
