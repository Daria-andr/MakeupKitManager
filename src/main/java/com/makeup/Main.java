package com.makeup;

import com.makeup.bean.CategoryGuide;
import com.makeup.bean.ExpiryChecker;
import com.makeup.config.AppConfig;
import com.makeup.service.MakeupService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        CategoryGuide categoryGuide = context.getBean(CategoryGuide.class);
        System.out.println("Available categories: " + categoryGuide.getAvailableCategories());


        MakeupService simpleService = context.getBean(MakeupService.class);
        simpleService.addProduct("Lipstick");


        MakeupService detailedService = context.getBean("detailedMakeupService", MakeupService.class);
        detailedService.addProduct("Foundation", "Beige", "2025-06-30");


        ExpiryChecker expiryChecker = context.getBean(ExpiryChecker.class);
        expiryChecker.checkInventory();

        context.close();
    }
}