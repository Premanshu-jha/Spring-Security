package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.Users;
import org.example.springsecurity.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UsersController {
   @Autowired
   private UsersService usersService;


   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestBody Users user){
        usersService.register(user);
        return ResponseEntity.ok().body(
                Map.of(
                   "message","User added successfully",
                   "userName",user.getUserName()
                )
        );
   }
   @PostMapping("/login")
   public String login(@RequestBody Users user){
        return usersService.verify(user);
   }
}
