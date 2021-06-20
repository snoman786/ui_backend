package com.sayyed.services;

import com.sayyed.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> listAll();

    public void save(Product product);

    public Product get(Integer id);

    public void delete(Integer id);
}
