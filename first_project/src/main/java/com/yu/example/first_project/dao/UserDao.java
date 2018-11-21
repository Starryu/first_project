package com.yu.example.first_project.dao;

import com.yu.example.first_project.vo.UserVO;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 测试用
 */
@Mapper
public interface UserDao {
    /**
     * 添加用户
     * @param userVO
     */
     void addUser(UserVO userVO);

    /**
     * 删除用户
     * @param userName
     */
     void deleteUser(String userName);

    /**
     * 更新用户
     * @param userVO
     */
     void updateUser(UserVO userVO);

    /**
     * 查询用户
     * @param userName
     * @return
     */
     UserVO selectUser(String userName);

    List<String>  selectUserName();

}
