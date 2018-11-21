package com.yu.example.first_project.service;


import com.yu.example.first_project.dao.UserDao;
import com.yu.example.first_project.vo.ResponseVO;
import com.yu.example.first_project.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseVO addUser(UserVO userVO) {
        List<String> nameList = userDao.selectUserName();
        if(nameList.contains(userVO.getUserName())){
            return ResponseVO.buildfailure("用户名已存在");
        }
        userDao.addUser(userVO);
        return ResponseVO.buildSuccess("添加用户成功");
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public void updateUser(UserVO userVO) {

    }

    @Override
    public UserVO selectUser(String userName) {
        return null;
    }
}
