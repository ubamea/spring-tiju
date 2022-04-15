package com.aubamea.exercise.com.aubamea.exercise.app.controllers;


import com.aubamea.exercise.com.aubamea.exercise.app.dto.UserDto;
import com.aubamea.exercise.com.aubamea.exercise.app.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<?>findUsers(){
        return new ResponseEntity<>(userService.findUsers(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?>saveUser(@Validated @RequestBody UserDto user){
        userService.saveUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable() Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable() Long id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }


    @GetMapping("/test")
    public String test(){
        return "Working...";
    }


}
