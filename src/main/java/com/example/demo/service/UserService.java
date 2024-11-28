package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // private List<User> users = new ArrayList<>(List.of(
    // new User(1L, "Alice", "alice@example.com"),
    //  new User(2L, "Bob", "bob@example.com"),
    //  new User(3L, "Charlie", "charlie@example.com")));

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int getAllUsersCount() {
        return getAllUsers().size();
    }

    public String deleteUsersById(Long id) {
        for (User user : getAllUsers()) {
            if (user.getId().equals(id)) {
                userRepository.delete(user);
                System.out.println("Deleted user: " + (user.getId()));
                return "User with id " + id + " deleted";
            }
        }
        return "User not found. Current users: " + getAllUsers();
    }

    public String addUser(User user) {
        userRepository.save(user);
        //users.add(user);
        getAllUsers();
        //  System.out.println("User added with ID: " + user.getName());
        // return "User added " + user.getName();
        return "";
    }

    public String updateUserById(Long id, User updatedUser) {
        for (User existingUser : getAllUsers()) {
            if (existingUser.getId().equals(id)) {
                //  existingUser.setName(updatedUser.getName());
                existingUser.setEmail(updatedUser.getEmail());
                System.out.println("Updating user: " + (existingUser.getEmail()));
                userRepository.save(existingUser);
                return "User with id " + id + " updated";
            }
        }
        return "User not found. Current users: " + getAllUsers();
    }

    public String getMultipleUsers() throws JsonProcessingException {
        List<User> users = new ArrayList<>();

        // users.add(new User(3L, "Michael", "Michael@example.com"));
        // users.add(new User(4L, "Jackson", "Jackson@example.com"));
        // users.add(new User(5L, "Peeter", "Peeter@example.com"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(users);
    }

    public String getFruits() throws JsonProcessingException {
        Map<Integer, String> fruits = new HashMap<>();
        fruits.put(1, "Apple");
        fruits.put(2, "Banana");
        fruits.put(3, "Cherry");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(fruits);
    }

    public User getUser() {
        // User user = new User(1L, "John Doe", "john.doe@example.com");
        // return user;
        return userRepository.findById(1L).get();
    }

        // public String hello() {
        //      return "Hello, World!";
        //}



    public String getUserById(Long userId) {
        return "User ID" + userId;
    }

   // public String greetUserByName(@PathVariable("name") String userName) {
  //      return "Hello" + userName;
  //  }

//    public String squareNumber(@PathVariable("number") int number) {
//        return "Square" + number * number;
//    }
//
//    public User getUserById(@PathVariable("id") Long id) {
//     //   List<User> users = List.of(
//             //  new User(1L, "Bob", "bob@example.com"),
//             //   new User(2L, "Alex", "alex@example.com"),
//             //  new User(3L, "Clen", "clen@example.com"));
//
//     //   for (User user : users) {
//      //      if (user.getId().equals(id)) {
//     //           return user;
//    //        }
//    //    }
//        return null;
//    }

    public String getUserOrder(@PathVariable("id") String userId,
                               @PathVariable("orderId") String orderId) {
        return "User ID: " + userId + " Order ID: " + orderId;
    }

    public String fullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Full name is: " + firstName + " " + lastName;
    }

    public String language(@RequestParam("Name") String name, @RequestParam("language") String language) {
        String greeting;
        switch (language) {
            case "en":
                greeting = ("Hello ");
                break;
            case "es":
                greeting = ("Hola ");
                break;
            case "fr":
                greeting = ("Bonjour ");
                break;
            case "est":
                greeting = ("Tere ");
                break;
            default:
                greeting = ("Hello ");
        }
        return greeting + ", " + name;
    }
}


