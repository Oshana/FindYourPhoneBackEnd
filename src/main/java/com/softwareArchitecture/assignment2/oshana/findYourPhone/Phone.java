package com.softwareArchitecture.assignment2.oshana.findYourPhone;

public class Phone {

    private int id;
    private String brand;
    private String model;
    private String details;
    private String price;
    private String offer;
    private String StoreName;
    private String searchTags;
    private String buyingUrl;

    public Phone() {
    }

    public int getId() { return id; }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getDetails() {
        return details;
    }

    public String getPrice() {
        return price;
    }

    public String getOffer() {
        return offer;
    }

    public String getStoreName() { return StoreName; }

    public String getSearchTags() {
        return searchTags;
    }

    public String getBuyingUrl() { return buyingUrl; }

    public void setId(int id) { this.id = id; }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setStoreName(String storeName) { StoreName = storeName; }

    public void setSearchTags(String searchTags) {
        this.searchTags = searchTags;
    }

    public void setBuyingUrl(String buyingUrl) { this.buyingUrl = buyingUrl; }
}
