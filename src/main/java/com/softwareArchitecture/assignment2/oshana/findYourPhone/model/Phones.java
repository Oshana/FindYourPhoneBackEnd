package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;
import java.util.Set;

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
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "phone_offer", joinColumns = @JoinColumn(name = "phone_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private Set<Offers> offers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_phones")
    private Users user;

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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOffers(Set<Offers> offers) {
        this.offers = offers;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public int getPrice() {
        return price;
    }

    public Set<Offers> getOffers() {
        return offers;
    }

    public Users getUser() {
        return user;
    }
}
