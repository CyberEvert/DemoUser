package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
  /*  @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }

   */
    //@GetMapping("/hello")
    //public String hello() {
    //    return userService.hello();
    //}
    @GetMapping("/multiple-users")
    public String getMultipleUsers() throws JsonProcessingException {
        return userService.getMultipleUsers();
    }
    @GetMapping("/fruits")
    public String getFruits() throws JsonProcessingException {
        return userService.getFruits();
    }
   // @GetMapping("/greet/{name}")
   // public String greetUserByName(@PathVariable("name") String userName) {
   //     return userService.greetUserByName(userName);
   // }
   // @GetMapping("/square/{number}")
   // public String squareNumber(@PathVariable("number") int number) {
   //     return userService.squareNumber(number);
   // }
    @GetMapping("/useres/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/user/{userId}/order/{orderId}")
    public String getUserOrder(@PathVariable("id") String userId,
                               @PathVariable("orderId") String orderId) {
        return userService.getUserOrder(userId, orderId);
    }
    // http://localhost:8080/api/users/fullname?firstName=John&lastName=Smith
    @GetMapping("/fullname")
    public String fullname(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return userService.fullname(firstName, lastName);
    }
    //http://localhost:8080/api/users/greet-by-language?Name=Kaisa&language=est
    @GetMapping("/greet-by-language")
    public String language(@RequestParam("Name") String name, @RequestParam("language") String language) {
        return userService.language(name, language);
    }
    @GetMapping("/get-all-users")
    private void users() {
        userService.getAllUsers();
    }
    @DeleteMapping("/delete-users-by-id/{id}")
    public String deleteUsersById(@PathVariable("id") Long userId) {
        return userService.deleteUsersById(userId);
    }
    @PostMapping("/add-user")
    public String addUsersById(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PutMapping("/update-user-details/{id}")
    public String updateUsersById(@PathVariable("id") Long userId, @RequestBody User incomingUserData) {
        return userService.updateUserById(userId, incomingUserData);
    }
}
