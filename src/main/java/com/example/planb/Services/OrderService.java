package com.example.planb.Services;

import com.example.planb.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
/*
ЗЗдесть реализованны методы для работы с таблицей orders
НЕ УСПЕЛ ДО КОНЦА ЗАКОНЧИТЬ
 */
public class OrderService {
    private SqlSessionFactory sqlSessionFactory;

    public OrderService(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    //выбрать всё
    public List<Order> selectAllOrders(){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            List<Order> list = session.selectList("OrderMapper.getAllOrders");
            return list;
        } finally {
            session.close();
        }
    }
    //Записать (НЕ ЗАКОНЧИЛ)
    public void insert(Order order){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("OrderMapper.insert", order);
            ClientService clientService = new ClientService();
            List<Client> client = clientService.selectClient(order.getClientId());
            ProductService productService = new ProductService();
            List<ProductType> product = productService.selectProduct(order.getProductId());
            ProductType p = product.get(0);
            p.setCount(p.getCount()- order.getCount());
            productService.update(p);
            Client c = client.get(0);
            c.setPurchases(c.getPurchases() + (p.getPrice() * p.getCount()));
            clientService.update(c);

            session.commit();
        } finally {
            session.close();
        }
    }
}
