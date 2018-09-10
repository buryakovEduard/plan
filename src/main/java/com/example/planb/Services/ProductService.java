package com.example.planb.Services;

import com.example.planb.MyBatisConnectionFactory;
import com.example.planb.Order;
import com.example.planb.ProductType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/*
* Здесть реализованны методы для работы с таблицей Product
*/

public class ProductService {
    private SqlSessionFactory sqlSessionFactory;

    public ProductService(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public List<ProductType> selectAllProducts(){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            List<ProductType> list = session.selectList("ProductMapper.getAllProducts");
            return list;
        } finally {
            session.close();
        }
    }

    public List<ProductType> selectProduct(long id){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            List<ProductType> list = session.selectList("ProductMapper.getProductById", id);
            return list;
        } finally {
            session.close();
        }
    }

    public void insert(ProductType productType){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("ProductMapper.insert", productType);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void update(ProductType productType){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("ClientMapper.update", productType);
            session.commit();
        } finally {
            session.close();
        }
    }
}
