package com.example.planb.Services;

import com.example.planb.Client;
import com.example.planb.MyBatisConnectionFactory;
import com.example.planb.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/*
    В данном классе реализованы методы для работы с таблицей клиентов
*/

import java.util.List;

public class ClientService {
    private SqlSessionFactory sqlSessionFactory;

    public ClientService(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    // Выбрать всех
    public List<Client> selectAllClients(){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            List<Client> list = session.selectList("ClientMapper.getAllClients");
            return list;
        } finally {
            session.close();
        }
    }
    //выбрать по id
    public Client selectClient(int id){
        System.out.println(id);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            Client list = session.selectOne("ClientMapper.getClientById", (int)id);
            return list;
        } finally {
            session.close();
        }
    }
    //Добавить
    public void insert(Client client){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("ClientMapper.insert", client);
            session.commit();
        } finally {
            session.close();
        }
    }
    //обновить
    public void update(Client client){

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("ClientMapper.update", client);
            session.commit();
        } finally {
            session.close();
        }
    }
}
