package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="phones")
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "details")
    private String details;

    @Column(name = "price")
    private long price;

    @Column(name = "searchTags")
    private String searchTags;

    @Column(name = "offer")
    private String offer;

    @Column(name="buyingUrl")
    private String buyingUrl;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "phone_offer", joinColumns = @JoinColumn(name = "phone_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
//    private Set<Offers> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_phones")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_phones")
    private Optional<OutSideStores> outSideStore;

    public void setId(int id) {
        this.id = id;
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

    public void setPrice(long price) {
        this.price = price;
    }

    public void setSearchTags(String searchTags) {
        this.searchTags = searchTags;
    }

//    public void setOffers(Set<Offers> offers) {
//        this.offers = offers;
//    }


    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setOutSideStore(Optional<OutSideStores> storeId) {
        this.outSideStore = storeId;
    }

    public void setBuyingUrl(String buyingUrl) {
        this.buyingUrl = buyingUrl;
    }

    public int getId() {
        return id;
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

    public long getPrice() {
        return price;
    }

    public String getSearchTags() {
        return searchTags;
    }

//    public Set<Offers> getOffers() {
//        return offers;
//    }

    public String getOffer() {
        return offer;
    }

    public Users getUser() {
        return user;
    }

    public Optional<OutSideStores> getOutSideStore() {
        return outSideStore;
    }

    public String getBuyingUrl() {
        return buyingUrl;
    }
}
