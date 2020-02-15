package com.softwareArchitecture.assignment2.oshana.findYourPhone;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.mock_eStores.Crawler;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Phones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.OutSideStoresRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.PhonesRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class PhoneSearchController {

    @Autowired
    PhonesRepository phonesRepository;

    @Autowired
    OutSideStoresRepository outSideStoresRepository;

    @Autowired
    Crawler crawler;

    @GetMapping("/search/{searchLine}")
    public List<Phone> searchPhone(@PathVariable String searchLine){
        List<Phone> results = new ArrayList<>();
        Phone matchedPhone = new Phone();
        Crawler crawler = new Crawler();
        
        List<Phones> phones = phonesRepository.findAll();
        for (Phones phone: phones
             ) {
                    String[] searchTags = phone.getSearchTags().split("#");
            for (String searchTag: searchTags
                 ) {
                    if(searchLine.equals(searchTag)){
                        matchedPhone.setId(phone.getId());
                        matchedPhone.setBrand(phone.getBrand());
                        matchedPhone.setModel(phone.getModel());
                        matchedPhone.setDetails(phone.getDetails());
                        matchedPhone.setPrice(phone.getPrice());
                        matchedPhone.setOffer(phone.getOffer());
                        matchedPhone.setStoreName(phone.getStoreName());
                        matchedPhone.setBuyingUrl(phone.getBuyingUrl());
                        results.add(matchedPhone);
                        break;
                    }
            }
        }

        Phone phoneFromStore01 = crawler.getDataFromStore01(searchLine);
        if(phoneFromStore01.getBrand() != null){
            results.add(phoneFromStore01);
        }

        Phone phoneFromStore02 = crawler.getDataFromStore02(searchLine);
        if(phoneFromStore02.getBrand() != null){
            results.add(phoneFromStore02);
        }

        Phone phoneFromStore03 = crawler.getDataFromStore03(searchLine);
        if(phoneFromStore03.getBrand() != null){
            results.add(phoneFromStore03);
        }

        return results;
    }

}
