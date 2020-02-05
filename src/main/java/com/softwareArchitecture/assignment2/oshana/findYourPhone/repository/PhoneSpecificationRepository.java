package com.softwareArchitecture.assignment2.oshana.findYourPhone.repository;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneSpecificationRepository extends JpaRepository<Phones, Integer> {
}
