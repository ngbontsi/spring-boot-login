package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Person;
import com.bezkoder.spring.login.models.UserInformation;
import com.bezkoder.spring.login.payload.request.UserInformationRequest;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.payload.response.ResourceNotFoundException;
import com.bezkoder.spring.login.repository.UserInformationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInformationService  {
    @Autowired
    private UserInformationRepository userInformationRepository;
    private ObjectMapper objectMapper;

    public Person getUserInformation(UserInformationRequest request){

            return getByFirstnameAndLastname(request.getFirstname(),request.getLastname());
    }

    public Boolean isUserExist(UserInformationRequest request){
        return userInformationRepository.existsByFirstnameAndLastname(request.getFirstname(), request.getLastname());

    }

    public Person getByFirstnameAndLastname(String username, String lastname){
        Optional<Person> userInformation = Optional.ofNullable(userInformationRepository.findByFirstnameAndLastname(username, lastname)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found")));
        return userInformation.get();
    }

    public Person findById(long parentId) {
        Optional<Person> userInformation = Optional.ofNullable(userInformationRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found")));
        return userInformation.get();
    }

    public void addUserDetails(UserInformationRequest userInformationRequest) {
        if (!isUserExist(userInformationRequest))
            saveUser(userInformationRequest);


    }

    private void saveUser(UserInformationRequest userInformationRequest) {


    }
}
