package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;

@Entity
@Table(name="Offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phone_offer")
    private Phones phone;

    @Column
    private String offer;

    public int getId() {
        return id;
    }

    public String getOffer() {
        return offer;
    }

    public Phones getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setPhones(Phones phone) {
        this.phone = phone;
    }
}
