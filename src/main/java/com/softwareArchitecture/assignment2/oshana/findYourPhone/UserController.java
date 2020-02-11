package com.softwareArchitecture.assignment2.oshana.findYourPhone;

import com.softwareArchitecture.assignment2.oshana.findYourPhone.model.Users;
import com.softwareArchitecture.assignment2.oshana.findYourPhone.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UsersRepository repository;

    @PostMapping("/register")
    public String register(@RequestBody Users user){
       repository.save(user);
       return "Hi " + user.getName() + " your Registration was successfully Completed !";
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

    @PostMapping("/savePhoneModel/{}")
    public String saveUserPhone()

}
