package com.softwareArchitecture.assignment2.oshana.findYourPhone.repository;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.OutSideStores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OutSideStoresRepository extends JpaRepository<OutSideStores , Integer> {
    OutSideStores findById(int id);
    OutSideStores findByName(String name);
}
