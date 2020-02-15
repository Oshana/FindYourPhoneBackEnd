package com.softwareArchitecture.assignment2.oshana.findYourPhone.mock_eStores;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.Phone;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class Crawler {

    public Phone getDataFromStore01(@PathVariable String searchLine){

        Phone phone = new Phone();

        String[][] phonesString = {{"Samsung","Galaxy A8","Screen:5.6, Ram: 2GB, Battery: 3200 mAh","55000",null,"Store 01","#Samsung Galaxy A8#Samsung GalaxyA8","https://www.samsung.com/us/mobile/galaxy-s10/buy/"},
                {"Huawei","Nova 3i","Screen:5.5, Ram: 3GB, Battery: 3500 mAh","45000","10% discount","Store 01","#Huawei Nova 3i#Huawei Nova3i","https://consumer.huawei.com/lk/phones/nova3i/"},
                {"Nokia","7.2","Screen:5.5, Ram: 2GB, Battery: 4200 mAh","60000","Power bank free","Store 01","#Nokia 7.2#Nokia7.2","https://www.amazon.in/Nokia-7-1_BL-Blue-64GB-Storage/dp/B07L8DZP8P"}};


        for (String[] phoneString: phonesString
             ) {
            String[] searchTags = phoneString[6].split("#");
            for (String searchTag: searchTags
            ) {
                if(searchLine.equals(searchTag)){
                    phone.setBrand(phoneString[0]);
                    phone.setModel(phoneString[1]);
                    phone.setDetails(phoneString[2]);
                    phone.setPrice(phoneString[3]);
                    phone.setOffer(phoneString[4]);
                    phone.setStoreName(phoneString[5]);
                    phone.setBuyingUrl(phoneString[7]);
                    break;
                }
            }

        }
        return phone;
    }

    public Phone getDataFromStore02(@PathVariable String searchLine){

        Phone phone = new Phone();

        String[][] phonesString = {{"Samsung","Galaxy A8","Screen:5.6, Ram: 2GB, Battery: 3200 mAh","54000","12% discount","Store 02","#Samsung Galaxy A8#Samsung GalaxyA8","https://www.samsung.com/us/mobile/galaxy-s10/buy/"},
                {"Huawei","Nova 3i","Screen:5.5, Ram: 3GB, Battery: 3500 mAh","44900","Free Pouch","Store 02","#Huawei Nova 3i#Huawei Nova3i","https://consumer.huawei.com/lk/phones/nova3i/"},
                {"Nokia","7.2","Screen:5.5, Ram: 2GB, Battery: 4200 mAh","55000",null,"Store 02","#Nokia 7.2#Nokia7.2","https://www.amazon.in/Nokia-7-1_BL-Blue-64GB-Storage/dp/B07L8DZP8P"}};


        for (String[] phoneString: phonesString
        ) {
            String[] searchTags = phoneString[6].split("#");
            for (String searchTag: searchTags
            ) {
                if(searchLine.equals(searchTag)){
                    phone.setBrand(phoneString[0]);
                    phone.setModel(phoneString[1]);
                    phone.setDetails(phoneString[2]);
                    phone.setPrice(phoneString[3]);
                    phone.setOffer(phoneString[4]);
                    phone.setStoreName(phoneString[5]);
                    phone.setBuyingUrl(phoneString[7]);
                    break;
                }
            }

        }
        return phone;
    }

    public Phone getDataFromStore03(@PathVariable String searchLine){

        Phone phone = new Phone();

        String[][] phonesString = {{"Samsung","Galaxy A8","Screen:5.6, Ram: 2GB, Battery: 3200 mAh","57000","8% discount","Store 03","#Samsung Galaxy A8#Samsung GalaxyA8","https://www.samsung.com/us/mobile/galaxy-s10/buy/"},
                {"Huawei","Nova 3i","Screen:5.5, Ram: 3GB, Battery: 3500 mAh","42000",null,"Store 03","#Huawei Nova 3i#Huawei Nova3i","https://consumer.huawei.com/lk/phones/nova3i/"},
                {"Nokia","7.2","Screen:5.5, Ram: 2GB, Battery: 4200 mAh","59900","HandsFree free","Store 03","#Nokia 7.2#Nokia7.2","https://www.amazon.in/Nokia-7-1_BL-Blue-64GB-Storage/dp/B07L8DZP8P"}};


        for (String[] phoneString: phonesString
        ) {
            String[] searchTags = phoneString[6].split("#");
            for (String searchTag: searchTags
            ) {
                if(searchLine.equals(searchTag)){
                    phone.setBrand(phoneString[0]);
                    phone.setModel(phoneString[1]);
                    phone.setDetails(phoneString[2]);
                    phone.setPrice(phoneString[3]);
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
