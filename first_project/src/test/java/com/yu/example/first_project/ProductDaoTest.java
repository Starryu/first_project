package com.yu.example.first_project;

import com.alibaba.fastjson.JSONObject;

import com.yu.example.first_project.dao.ProductDao;
import com.yu.example.first_project.vo.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void insert(){
        ProductVO productVO =new ProductVO();
        productVO.setName("yuyuyu");
        productVO.setInventory(5);
        productVO.setUserAddName("xx");
        productVO.setAddTime(new Date());
        productDao.insert(productVO);
    }
    @Test
    public void delete(){
        productDao.delete(2);
    }

    @Test
    public void update(){
        ProductVO productVO =new ProductVO();
        productVO.setProductId("3");
        productVO.setName("yuyuyu");
        productVO.setInventory(2);
        productDao.update(productVO);
    }

    @Test
    public void alertNum(){
        productDao.alertNumber(4,1,new Date());
    }

    @Test
    public void selectById(){
        System.out.println(JSONObject.toJSONString(productDao.selectById(3)));
    }

    @Test
    public void selectAll(){
        System.out.println(JSONObject.toJSONString(productDao.selectAll()));
    }

    @Test
    public void selectByPage(){
        System.out.println(JSONObject.toJSONString(productDao.selectByPage(1,2)));
    }

    @Test
    public void selectProductName(){
        List<String> list =new ArrayList<>();
        list=productDao.selectProductName();
        System.out.println(JSONObject.toJSONString(list));
    }


}
