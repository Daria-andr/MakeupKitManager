package com.makeup.bean;

import com.makeup.service.MakeupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ExpiryChecker { //синглтон-бин с lazy инициализацией
    private final MakeupService makeupService;

    @Autowired
    public ExpiryChecker(MakeupService makeupService) {
        this.makeupService = makeupService;
        System.out.println("ExpiryChecker initialized lazily");
    }

    public void checkInventory() {
        int totalProducts = makeupService.getAllProducts().size();
        System.out.println("Total products in makeup kit: " + totalProducts);
    }
}