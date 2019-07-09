package com.redcampo.app.Service;

import com.redcampo.app.Entity.Product;
import com.redcampo.app.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> findAll(){
        return productRepo.findAll();
    }

    public List<Product> findByProductId(Long id){
        return productRepo.findByProductId(id);
    }

    public Product create(Product pro){
        return productRepo.save(pro);
    }

    public void delete(Product pro) { productRepo.delete(pro); }
}
