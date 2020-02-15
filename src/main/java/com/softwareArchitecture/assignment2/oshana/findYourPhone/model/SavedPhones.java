package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;

@Entity
@Table(name="savedPhones")
public class SavedPhones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "details")
    private String details;

    @Column(name = "price")
    private String price;

    @Column(name = "store")
    private String StoreName;

    @Column(name = "offer")
    private String offer;

    @Column(name="buyingUrl")
    private String buyingUrl;

    @Column(name = "subscribe")
    private boolean subscribe;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return user;
    }

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

    public String getStoreName() {
        return StoreName;
    }

    public String getOffer() {
        return offer;
    }

    public String getBuyingUrl() {
        return buyingUrl;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int user) {
        this.user = user;
    }

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

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setBuyingUrl(String buyingUrl) {
        this.buyingUrl = buyingUrl;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }
}
