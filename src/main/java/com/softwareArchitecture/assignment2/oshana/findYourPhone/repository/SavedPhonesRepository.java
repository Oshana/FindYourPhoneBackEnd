package com.softwareArchitecture.assignment2.oshana.findYourPhone.repository;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.SavedPhones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SavedPhonesRepository extends JpaRepository<SavedPhones, Integer> {
    List<SavedPhones> getAllByUser(int id);
    SavedPhones findById(int id);
}
