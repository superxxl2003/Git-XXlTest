package com.xxlspringboot.usermanage.controller;

import com.xxlspringboot.usermanage.entity.User;
import com.xxlspringboot.usermanage.myexception.UserNotFoundException;
import com.xxlspringboot.usermanage.request.CreateUserRequest;
import com.xxlspringboot.usermanage.request.UpdateUserRequest;
import com.xxlspringboot.usermanage.response.UserResponse;
import com.xxlspringboot.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public UserResponse saveUser(@RequestBody CreateUserRequest createUserRequest){
        User user = userService.createUser(createUserRequest);
        return new UserResponse(user);
    }

    @RequestMapping("/getUserByCity/{city}")
    public List<UserResponse> getUseByCity(@PathVariable String city){
        List<User> userList = userService.findByCity(city);
        List<UserResponse> userResponseList = new ArrayList<UserResponse>();

        userList.stream().forEach(user -> {
            userResponseList.add(new UserResponse(user));
        });

        return userResponseList;
    }

    @RequestMapping("/getAllUser")
    public List<UserResponse> getAllUsers(){
        List<User> userList = userService.findAllUsers();

        List<UserResponse> userResponseList = new ArrayList<UserResponse>();

        userList.stream().forEach(user -> {
            userResponseList.add(new UserResponse(user));
        });

        return userResponseList;
    }

    @RequestMapping("/getUserByName/{name}")
    public List<UserResponse> getUserByName(@PathVariable String name){
        List<User> userList = userService.findByName(name);
        if(!userList.isEmpty()) {
            List<UserResponse> userResponseList = new ArrayList<UserResponse>();

            userList.stream().forEach(user -> {
                userResponseList.add(new UserResponse(user));
            });

            return userResponseList;
        }else
            throw new UserNotFoundException("User not exist");
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteById(@PathVariable long id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUser")
    public UserResponse updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        User user = userService.updateUser(updateUserRequest);
        return new UserResponse(user);
    }

    @RequestMapping("/getUserWithPagination")
    public List<UserResponse> getUserWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<User> userList = userService.getAllUserWithPagination(pageNo, pageSize);
        if(userList.isEmpty())
            throw new UserNotFoundException();
        else{
            List<UserResponse> userResponseList = new ArrayList<UserResponse>();

            userList.stream().forEach(user -> {
                userResponseList.add(new UserResponse(user));
            });

            return userResponseList;
        }
    }

}
