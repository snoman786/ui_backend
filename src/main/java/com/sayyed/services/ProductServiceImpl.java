package com.sayyed.services;

import com.sayyed.controllers.ProductsApiDelegate;
import com.sayyed.model.Product;
import com.sayyed.repositories.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductsApiDelegate {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<Product>> listProducts() {

        List<com.sayyed.domain.Product> productList = productRepo.findAll();
        List<Product> retList = productList.stream().map(this :: convertToDto).collect(Collectors.toList());
        return new ResponseEntity<List<Product>>(retList, HttpStatus.OK);
    }

    //TODO : This should go to Generic one .OK for now .
    private Product convertToDto(com.sayyed.domain.Product product) {
        Product productDto = modelMapper.map(product, Product.class);
        return productDto;
    }
}
