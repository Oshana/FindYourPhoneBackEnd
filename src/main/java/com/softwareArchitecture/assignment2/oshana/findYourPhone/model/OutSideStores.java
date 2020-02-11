package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    private Email email;

    @Column(name = "url")
    private String url;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "outSideStores_phones", joinColumns = @JoinColumn(name = "outSideStores_id"), inverseJoinColumns = @JoinColumn(name = "phones_id"))
    private Set<Phones> phones;

    public OutSideStores(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    public Set<Phones> getPhones() {
        return phones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPhones(Set<Phones> phones) {
        this.phones = phones;
    }
}
