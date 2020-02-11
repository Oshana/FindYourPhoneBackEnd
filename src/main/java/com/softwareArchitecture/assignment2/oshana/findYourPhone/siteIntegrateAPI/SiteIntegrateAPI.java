package com.softwareArchitecture.assignment2.oshana.findYourPhone.siteIntegrateAPI;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.Phone;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.OutSideStores;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Phones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.OutSideStoresRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SiteIntegrateAPI {

    @Autowired
    PhonesRepository phonesRepository;

    @Autowired
    OutSideStoresRepository outSideStoresRepository;

    @PostMapping("/integrateService/addData/{storeId}/{phones}")
    public List<String> integrateOutSitePhones(@PathVariable int storeId, @PathVariable List<Phone> phones){

        Optional<OutSideStores> outSideStore = outSideStoresRepository.findById(storeId);
        List<String> bugs = new ArrayList<>();

        if(outSideStore.isPresent()){
            for (Phone phone: phones
            ) {
                try {
                    Phones tempPhone = new Phones();
                    tempPhone.setBrand(phone.getBrand());
                    tempPhone.setModel(phone.getModel());
                    tempPhone.setDetails(phone.getDetails());
                    tempPhone.setPrice(phone.getPrice());
                    tempPhone.setSearchTags(phone.getSearchTags());
                    tempPhone.setOffer(phone.getOffer());
                    tempPhone.setOutSideStore(outSideStoresRepository.findById(storeId));
                    tempPhone.setBuyingUrl(phone.getBuyingUrl());
                    phonesRepository.save(tempPhone);
                } catch (Exception e) {
                    bugs.add("Error: Please check the provided data correctly for the phone "+phone.getBrand()+","
                            +phone.getModel()+"  and resend ! Thank you.");
                }
            }
        }else {
            bugs.add("Your store with id: "+storeId+"has not been registered with us. Please register your store or please" +
                    " check the correctness of the id !");
        }

        if(bugs.size() == 0) {
            bugs.add("Data added Successfully !!");
        }
        return bugs;
    }
}
