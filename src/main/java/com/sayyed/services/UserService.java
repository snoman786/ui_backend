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

    @Override
    public ResponseEntity<User> createUser(User user) {

        com.sayyed.domain.User creatredUser  = userRepo.save(convertToEO(user));
        return new ResponseEntity<User>(convertToDto(creatredUser),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer id) {
        userRepo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUser(Integer id) {

        com.sayyed.domain.User user =  userRepo.findById(id).orElseThrow(RuntimeException::new);
        return new ResponseEntity<User>(convertToDto(user),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUser(Integer id, User user) {
        com.sayyed.domain.User existingUser =  userRepo.findById(id).orElseThrow(RuntimeException::new);
        existingUser.setUserName(user.getUserName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        com.sayyed.domain.User updatedUser  = userRepo.save(existingUser);
        return new ResponseEntity<User>(convertToDto(updatedUser),HttpStatus.OK);
    }

    //TODO : These two methods should go to Generic one .OK for now .
    private User convertToDto(com.sayyed.domain.User user) {
        User userDto = modelMapper.map(user, User.class);
        return userDto;
    }

    private com.sayyed.domain.User convertToEO(User user){
        com.sayyed.domain.User userEO = modelMapper.map(user,com.sayyed.domain.User.class);
        return userEO;
    }


}
