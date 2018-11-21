package com.yu.example.first_project.dao;


import com.yu.example.first_project.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 产品表数据库接口
 * @author yuxingcheng
 * @date 2018-11-5
 */
@Mapper
public interface ProductDao {
    /**
     * 增加产品
     * @param productVO
     */
    public void insert(ProductVO productVO);

    /**
     * 删除产品信息
     * @param productId
     */
    public void delete(int productId);

    /**
     * 修改产品信息
     * @param productVO
     */
    public void update(ProductVO productVO);

    /**
     * 修改商品数量
     * @param productId
     */
    public void alertNumber(@Param("productId") int productId, @Param("number") int num, @Param("alertTime") Date alertTime);

    /**
     * 根据产品id查询产品信息
     * @param productId
     */
    public ProductVO selectById(int productId);

    /**
     * 查询所有的产品信息
     * @return
     */
    public List<ProductVO> selectAll();

    /**
     * 查询所有商品的名称
     * @return
     */
    public List<String> selectProductName();

    /**
     * 分页查询
     * @param currPage
     * @param pageSize
     * @return
     */
    public List<ProductVO> selectByPage(@Param("currPage") int currPage, @Param("pageSize") int pageSize);
}
