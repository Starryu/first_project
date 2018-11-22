package com.yu.example.first_project.controller;

import com.yu.example.first_project.dao.UserDao;
import com.yu.example.first_project.service.UserService;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST)
    public ResponseVO addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    }

    @RequestMapping(value = "/user/delete/{userName}",method = RequestMethod.POST)
    public ResponseVO deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){
        return userService.updateUser(userVO);
    }

    @RequestMapping(value = "/user/select/{userName}",method = RequestMethod.GET)
    public ResponseVO selectUserName(@PathVariable String userName){
        return userService.selectUser(userName);
    }


}
