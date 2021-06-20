package com.sayyed.services.impl;

import com.sayyed.domain.Product;
import com.sayyed.repositories.ProductRepo;
import com.sayyed.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> listAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product get(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }
}
