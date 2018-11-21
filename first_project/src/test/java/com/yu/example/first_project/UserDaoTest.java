package com.yu.example.first_project;

import com.alibaba.fastjson.JSONObject;
import com.yu.example.first_project.dao.UserDao;
import com.yu.example.first_project.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void addTest(){
        UserVO userVO =new UserVO();
        userVO.setUserName("yuu");
        userVO.setUserPassword("123123");
        userVO.setEmail("512688011@qq.com");
        userDao.addUser(userVO);
    }

    @Test
    public void deleteTest(){
        userDao.deleteUser("yuu");
    }

    @Test
    public void updateTest(){
        UserVO userVO =new UserVO();
        userVO.setUserId(1);
        userVO.setUserPassword("1234");
        userDao.updateUser(userVO);
    }

    @Test
    public void selectTest(){
        System.out.println(JSONObject.toJSONString(userDao.selectUser("yu")));
    }

    @Test
    public void selectNameTest(){
        System.out.println(JSONObject.toJSONString(userDao.selectUserName()));
    }
}
