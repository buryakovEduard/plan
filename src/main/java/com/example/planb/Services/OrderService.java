package com.example.planb.Services;

import com.example.planb.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
/*
Здесть реализованны методы для работы с таблицей orders
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
    //Записать новую транзакцию и изменить поля в других таблицах по формулам
    public void insert(Order order){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("OrderMapper.insert", order);
            ClientService clientService = new ClientService();
            ProductService productService = new ProductService();
            Client client = clientService.selectClient(order.getClientId()); // находит клинета по id который указан в транзакции
            ProductType p = productService.selectProduct(order.getProductId()); // находит продукт по id который указан в транзакции
// добавляет сумму в поле общей суммы клиета по формуле (нанешняя сумма + (цена товара * количество купленного товара))
            client.setPurchases(client.getPurchases() + (p.getPrice() * order.getCount()));
            clientService.update(client);
// изменяет количество товара на складе по формуле (нынешнее количество - колчество купленного товара)
            p.setCount(p.getCount() - order.getCount());
            productService.update(p);
            session.commit();
        } finally {
            session.close();
        }
    }
}
