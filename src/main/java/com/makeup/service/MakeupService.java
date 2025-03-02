package com.makeup.service;

import com.makeup.model.MakeupProduct;

import java.util.Map;

public interface MakeupService {
    void addProduct(String category);
    void addProduct(String category, String shade, String expiryDate);
    Map<String, MakeupProduct> getAllProducts();
}