package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.*;
import com.bezkoder.spring.login.payload.request.UserInformationRequest;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.security.services.UserInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    UserInformationService userInformationService;


    @PostMapping("/user/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserInformationRequest userInformationRequest) {

        if (userInformationService.isUserExist(userInformationRequest)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User already exist"));
        }

       userInformationService.addUserDetails(userInformationRequest);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/user/addParent")
    public ResponseEntity<?> addPanents(@Valid @RequestBody UserInformationRequest userInformationRequest) {
        return addUser(userInformationRequest);
    }

}
