package com.santanaanalopess.comerciosdeprodutos.controller;

import com.santanaanalopess.comerciosdeprodutos.model.User;
import com.santanaanalopess.comerciosdeprodutos.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

     private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){
       return ResponseEntity.status(HttpStatus.CREATED).body(user) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user=userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users=userService.fimdAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }




}
