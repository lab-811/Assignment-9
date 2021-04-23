package org.example.controller;

import org.example.entity.Role;
import org.example.entity.User;
import org.example.entity.UserData;
import org.example.repository.RoleRepository;
import org.example.repository.UserDataRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDataRepository userDataRepository;


    @GetMapping
    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userRepository.deleteById(id);
    }

    @PostMapping("/registration")
    public void registration(@RequestBody User user){
        Role role = roleRepository.findByName("USER");
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRoles(Collections.singletonList(role));

        userService.createUser(newUser);
    }





    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {


        userService.updateUser(id, user);
    }










//    @PutMapping("/{id}")
//    public UserData updateUser(@PathVariable Long id, @RequestBody UserData userData){
//        userData.setId(id);
//        return  userDataRepository.saveAndFlush(userData);
//    }
//
////    @DeleteMapping("/{id}")
////    public void deleteUser(@PathVariable Long id) {
////
////        userRepository.deleteById(id);
////    }
//
//    @PostMapping("/userData")
//    public UserData createUser(@RequestBody UserData userData){
//        return userDataRepository.saveAndFlush(userData);
//    }
//
//    @PatchMapping("/{id}")
//    public User updateUserAge(@PathVariable Long id,
//                              @RequestParam String password) {
//        User user = userRepository.findById(id).get();
//        user.setPassword(password);
//
//        return userRepository.saveAndFlush(user);
//    }
//
//    @DeleteMapping("/userData/{id}")
//    public void deleteUserData(@PathVariable Long id) {
//
//        userDataRepository.deleteById(id);
//    }


}
