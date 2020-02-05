package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;

@Entity
@Table(name="Offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String offer;

    @Column
    private String model;

    @Column
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_offer")
    private Phones phones;

    public int getId() {
        return id;
    }

    public String getOffer() {
        return offer;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }
}
