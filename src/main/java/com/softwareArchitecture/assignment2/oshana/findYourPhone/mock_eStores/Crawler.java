package com.softwareArchitecture.assignment2.oshana.findYourPhone.mock_eStores;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.Phone;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Service
public class Crawler {

//    @PostMapping("/1/{searchLine}")
    public Phone getDataFromStore01(@PathVariable String searchLine){

        Phone phone = new Phone();

        String[][] phonesString = {{"Samsung","Galaxy A8","Screen:5.6, Ram: 2GB, Battery: 3200 mAh","55000",null,"Store 01","#Samsung Galaxy A8#Samsung GalaxyA8","https://store01.lk/p1"},
                {"Huawei","Nova 2i","Screen:5.5, Ram: 3GB, Battery: 3500 mAh","45000","10% discount","Store 01","#Huawei nova 2i#Huawei Nova2i","https://store01.lk/p2"},
                {"Nokia","7.2","Screen:5.5, Ram: 2GB, Battery: 4200 mAh","60000","Power bank free","Store 01","#Nokia 7.2#Nokia7.2","https://store01.lk/p3"}};


        for (String[] phoneString: phonesString
             ) {
            String[] searchTags = phoneString[6].split("#");
            for (String searchTag: searchTags
            ) {
                if(searchLine.equals(searchTag)){
                    phone.setBrand(phoneString[0]);
                    phone.setModel(phoneString[1]);
                    phone.setDetails(phoneString[2]);
                    phone.setPrice(Integer.parseInt(phoneString[3]));
                    phone.setOffer(phoneString[4]);
                    phone.setStoreName(phoneString[5]);
                    phone.setBuyingUrl(phoneString[7]);
                    break;
                }
            }

        }
        return phone;
    }
}
