package com.makeup.service;

import com.makeup.model.MakeupProduct;
import com.makeup.repository.MakeupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DetailedMakeupService implements MakeupService {
    private final MakeupRepository makeupRepository;

    @Autowired
    public DetailedMakeupService(MakeupRepository makeupRepository) {
        this.makeupRepository = makeupRepository;
    }

    @Override
    public void addProduct(String category) {
        MakeupProduct product = new MakeupProduct(category);
        makeupRepository.addProduct(product);
        System.out.println("Added basic product: " + category);
    }

    @Override
    public void addProduct(String category, String shade, String expiryDate) {
        MakeupProduct product = new MakeupProduct(category, shade, expiryDate);
        makeupRepository.addProduct(product);
        System.out.println("Added detailed product: " + category + ", shade: " + shade + ", expires: " + expiryDate);
    }

    @Override
    public Map<String, MakeupProduct> getAllProducts() {
        return makeupRepository.getAllProducts();
    }
}