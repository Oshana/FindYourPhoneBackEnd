package com.softwareArchitecture.assignment2.oshana.findYourPhone;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Phones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.SavedPhones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.OutSideStoresRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.PhonesRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.SavedPhonesRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SendEmailController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    SavedPhonesRepository savedPhonesRepository;

    @Autowired
    OutSideStoresRepository outSideStoresRepository;

    @Autowired
    PhonesRepository phonesRepository;

    @Autowired
    private JavaMailSender javaMailSender;



    @GetMapping("/admin/sendOffers")
    private List<String> sendOffers(){
        List<String> sentEmails = new ArrayList<>();
        List<SavedPhones> savedPhones = savedPhonesRepository.findAll();
        for (SavedPhones savedPhone: savedPhones
        ) {
            if(savedPhone.isSubscribe()){
                String email = repository.findById(savedPhone.getUserId()).get().getEmail();
                String model = savedPhone.getModel();
                String brand = savedPhone.getBrand();
                Phones phone = phonesRepository.findByModelAndBrand(model,brand);
                if(phone != null){
                    if(phone.getOffer() != null ){
                        sentEmails.add(email);
                        SimpleMailMessage msg = new SimpleMailMessage();
                        msg.setTo(email);
                        msg.setSubject("You have a new Offer for the phone "+brand+" "+model);
                        msg.setText(phone.getOffer());
//                        javaMailSender.send(msg);
                    }
                }
            }
        }
        return sentEmails;
    }
}
