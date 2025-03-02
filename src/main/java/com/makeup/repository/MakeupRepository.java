package com.makeup.repository;

import com.makeup.model.MakeupProduct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MakeupRepository {
    private Map<String, MakeupProduct> products = new HashMap<>(); // Ключ - категория + оттенок

    public void addProduct(MakeupProduct product) {
        String key = product.getCategory() + "_" + product.getShade();
        products.put(key, product);
    }

    public MakeupProduct getProduct(String category, String shade) {
        return products.get(category + "_" + shade);
    }

    public Map<String, MakeupProduct> getAllProducts() {
        return new HashMap<>(products);
    }
}