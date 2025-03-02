package com.makeup;

import com.makeup.bean.CategoryGuide;
import com.makeup.bean.ExpiryChecker;
import com.makeup.config.AppConfig;
import com.makeup.service.MakeupService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Проверяем eagerly initialized bean
        CategoryGuide categoryGuide = context.getBean(CategoryGuide.class);
        System.out.println("Available categories: " + categoryGuide.getAvailableCategories());

        MakeupService simpleService = context.getBean(MakeupService.class);
        simpleService.addProduct("Lipstick"); // Нормальный случай
        simpleService.addProduct(""); // Ошибка — пустая категория

        MakeupService detailedService = context.getBean("detailedMakeupService", MakeupService.class);
        detailedService.addProduct("Foundation", "Beige", "2025-06-30"); // Нормальный случай
        detailedService.addProduct("", "Red", "2025-12-31"); // Ошибка — пустая категория

        ExpiryChecker expiryChecker = context.getBean(ExpiryChecker.class);
        expiryChecker.checkInventory();

        context.close();
    }
}