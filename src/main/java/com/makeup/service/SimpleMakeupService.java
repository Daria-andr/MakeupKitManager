package com.makeup.service;

import com.makeup.model.MakeupProduct;
import com.makeup.repository.MakeupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Primary
public class SimpleMakeupService implements MakeupService {
    private final MakeupRepository makeupRepository;

    @Autowired
    public SimpleMakeupService(MakeupRepository makeupRepository) {
        this.makeupRepository = makeupRepository;
    }

    @Override
    public void addProduct(String category) {
        MakeupProduct product = new MakeupProduct(category);
        makeupRepository.addProduct(product);
        System.out.println("Added simple product: " + category);
    }

    @Override
    public void addProduct(String category, String shade, String expiryDate) {
        addProduct(category);
    }

    @Override
    public Map<String, MakeupProduct> getAllProducts() {
        return makeupRepository.getAllProducts();
    }
}