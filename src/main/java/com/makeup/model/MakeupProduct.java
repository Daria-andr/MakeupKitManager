package com.makeup.model;

public class MakeupProduct {
    private String category;
    private String shade;
    private String expiryDate;

    public MakeupProduct(String category) {
        this.category = category;
        this.shade = "unknown";
        this.expiryDate = "unknown";
    }

    public MakeupProduct(String category, String shade, String expiryDate) {
        this.category = category;
        this.shade = shade;
        this.expiryDate = expiryDate;
    }

    public String getCategory() { return category; }
    public String getShade() { return shade; }
    public String getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "MakeupProduct{category='" + category + "', shade='" + shade + "', expiryDate='" + expiryDate + "'}";
    }
}