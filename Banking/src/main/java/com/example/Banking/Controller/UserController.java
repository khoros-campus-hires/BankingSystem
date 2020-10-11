package com.example.Banking.Controller;

import java.util.List;
import java.util.Optional;


import com.example.Banking.Exception.ResourceNotFoundException;
import com.example.Banking.Model.User;
import com.example.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/GetAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/GetOneUser/{id}")
    public Optional<User> getOneUser(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId){
        userRepository.deleteById(userId);
    }

    @PutMapping("/UpdateUser/{id}")
    public void updateEmployee(@PathVariable(value = "id") Long userId,
                               /*@Valid*/ @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setfirstName(userDetails.getfirstName());
        user.setlastName(userDetails.getlastName());
        user.setDob((userDetails.getDob()));
        user.setAge(userDetails.getAge());
        user.setAddress(userDetails.getAddress());
        user.setContact_number(userDetails.getContact_number());
        user.setEmail((userDetails.getEmail()));
        user.setBalance(userDetails.getBalance());
        userRepository.save(user);
    }

    @PutMapping("/transaction/{id}")
        public String transaction(@PathVariable(value = "id") Long userId, @RequestBody User userAmount) throws ResourceNotFoundException {
        User sender = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        //deducting
        if( sender.getBalance() > userAmount.getBalance()) {
            long hi = sender.setBalance(sender.getBalance() - userAmount.getBalance());
            sender.setBalance(hi);
            userRepository.save(sender);
        }
        else {
            return "invalid balance";
        }


        //crediting
        User reciever =userRepository.findById(userAmount.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        long hii = reciever.setBalance(reciever.getBalance() + userAmount.getBalance());
        userRepository.save(reciever);



        return "success";

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Student_details" );
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin( );
        Query query = (Query) em.createQuery("Select * from users");
        List<String> list =query.getResultList();*/
    }


    /*
     {
        "id": 345,
        "firstName": "Nithi",
        "lastName": "nandha",
        "dob": "2017-06-15",
        "age": 104,
        "address": "kailasa",
        "contact_number": 9999999999,
        "email": "nithi@kailash.com"
    }
    */
}
