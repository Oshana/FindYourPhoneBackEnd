package com.softwareArchitecture.assignment2.oshana.findYourPhone;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Phones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.SavedPhones;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Users;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.OutSideStoresRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.PhonesRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.SavedPhonesRepository;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    SavedPhonesRepository savedPhonesRepository;

    @Autowired
    OutSideStoresRepository outSideStoresRepository;

    @Autowired
    PhonesRepository phonesRepository;

    @PostMapping("/validateLogin")
    public Boolean validateLogin(@RequestBody Credentials credentials){
        Users user = repository.findByNameAndPassword(credentials.getUsername(), credentials.getPassword());
        return user != null;
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user){
       repository.save(user);
       return "Hi " + user.getName() + " your Registration was successfully Completed ! Please Login.";
    }

    @PostMapping("/saveUserPhone/{username}")
    public String register(@PathVariable String username, @RequestBody Phone phone){
        try {
            SavedPhones dbPhone = new SavedPhones();
            dbPhone.setBrand(phone.getBrand());
            dbPhone.setModel(phone.getModel());
            dbPhone.setDetails(phone.getDetails());
            dbPhone.setPrice(phone.getPrice());
            dbPhone.setOffer(phone.getOffer());
            dbPhone.setStoreName(phone.getStoreName());
            dbPhone.setBuyingUrl(phone.getBuyingUrl());
            dbPhone.setUserId(repository.findByName(username).getId());
            dbPhone.setSubscribe(false);
            savedPhonesRepository.save(dbPhone);
            return "Phone Saved Successfully";
        }catch (Exception e){
            System.out.println(e);
            return "Failed to Save Phone";
        }
    }

    @GetMapping("/getAllPhones/{username}")
    public List<SavedPhones> findAllSavedPhones(@PathVariable String username){
        int userId = repository.findByName(username).getId();
        return savedPhonesRepository.getAllByUser(userId);
    }

    @DeleteMapping("/removePhone/{username}/{id}")
    public List<SavedPhones> findAllSavedPhones(@PathVariable String username,@PathVariable int id){
        savedPhonesRepository.deleteById(id);
        int userId = repository.findByName(username).getId();
        return savedPhonesRepository.getAllByUser(userId);
    }

    @GetMapping("/subscribe/{username}/{id}")
    public List<SavedPhones> subscribe(@PathVariable String username,@PathVariable int id){
        SavedPhones phone = savedPhonesRepository.findById(id);
        phone.setSubscribe(true);
        savedPhonesRepository.save(phone);
        int userId = repository.findByName(username).getId();
        return savedPhonesRepository.getAllByUser(userId);
    }

    @GetMapping("/unSubscribe/{username}/{id}")
    public List<SavedPhones> unSubscribe(@PathVariable String username,@PathVariable int id){
        SavedPhones phone = savedPhonesRepository.findById(id);
        phone.setSubscribe(false);
        savedPhonesRepository.save(phone);
        int userId = repository.findByName(username).getId();
        return savedPhonesRepository.getAllByUser(userId);
    }

    @GetMapping("/getAllUsers")
    public List<Users> findAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/findUser/{email}")
    public List<Users> findUser(@PathVariable String email){
        return repository.findByEmail(email);
    }

    @DeleteMapping("/cancel/{id}")
    public List<Users> cancelRegistration(@PathVariable int id){
        repository.deleteById(id);
        return repository.findAll();
    }

}
