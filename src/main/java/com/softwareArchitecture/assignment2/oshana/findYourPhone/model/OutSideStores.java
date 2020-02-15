package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "outSideStores")
public class OutSideStores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "url")
    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "outSideStores_phones", joinColumns = @JoinColumn(name = "outSideStores_id"), inverseJoinColumns = @JoinColumn(name = "phones_id"))
    private List<Phones> phones;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }
}
