package net.javaguides.demo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.demo.entity.user;
import net.javaguides.demo.service.UserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController
{
    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user user)
    {
        user savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

        //build get user by Id REST API

    // http://localhost:5454/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<user> getUserByID(@PathVariable("id") Long userId)
    {
      user user =  userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    ///build get all users REST API
    @GetMapping
    public ResponseEntity<List<user>> getAllUsers()
    {
       List<user> users = userService.getAllUser();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1

    public ResponseEntity<user> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody user user)
    {
        user updatedUser = userService.updateUser(userId,user);
        if(updatedUser!=null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //build

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("user deleted successfully", HttpStatus.OK);
    }
}
