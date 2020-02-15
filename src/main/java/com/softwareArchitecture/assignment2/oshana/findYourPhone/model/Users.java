package com.softwareArchitecture.assignment2.oshana.findYourPhone.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_phones", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "phones_id"))
    private Set<Phones> savedPhones;

    public Users() {
    }

    public Users(Users users) {
        this.email = users.getEmail();
        this.roles = users.getRoles();
        this.name = users.getName();
        this.id = users.getId();
        this.password = users.getPassword();
        this.savedPhones = users.getSavedPhones();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Set<Phones> getSavedPhones() {
        return savedPhones;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setSavedPhones(Set<Phones> savedPhones) {
        this.savedPhones = savedPhones;
    }
}