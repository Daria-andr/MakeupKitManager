package com.makeup.bean;

import org.springframework.stereotype.Component;

@Component
public class CategoryGuide { //синглтон-бин с eager инициализацией
    private final String[] categories = {"Lipstick", "Foundation", "Mascara"};

    public CategoryGuide() {
        System.out.println("CategoryGuide initialized eagerly");
    }

    public String getAvailableCategories() {
        return String.join(", ", categories);
    }
}