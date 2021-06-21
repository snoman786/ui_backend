package com.sayyed.services;

import com.sayyed.controllers.UsersApiDelegate;
import com.sayyed.model.User;
import com.sayyed.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements UsersApiDelegate {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<User>> listUser() {
        List<com.sayyed.domain.User> userList = userRepo.findAll();
        List<User> retList = userList.stream().map(this :: convertToDto).collect(Collectors.toList());
        return new ResponseEntity<List<User>>(retList, HttpStatus.OK);
    }

    //TODO : This should go to Generic one .OK for now .
    private User convertToDto(com.sayyed.domain.User user) {
        User userDto = modelMapper.map(user, User.class);
        return userDto;
    }
}
