package com.example.planb;

import com.example.planb.Services.ClientService;
import com.example.planb.Services.OrderService;
import com.example.planb.Services.ProductService;
import com.example.planb.Services.ReportService;
//Имитация работы
public class Imitation {
    //Добавить продукта на склад
    public static void newProduct(int price, String name, int count){
        ProductService productService = new ProductService();
        ProductType newProduct = new ProductType();
        newProduct.setNameProduct(name);
        newProduct.setPrice(price);
        newProduct.setCount(count);
        productService.insert(newProduct);
    }
    //Добавление клиента в БД
    public static void newClient(String name){
        ClientService clientService = new ClientService();
        Client newClient = new Client();
        newClient.setName(name);
        clientService.insert(newClient);
    }
    //Создание транзакции
    public static void newOrder(int count, String date, int productId, int clientId){
        OrderService orderService = new OrderService();
        Order newOrder = new Order();
        newOrder.setCount(count);
        newOrder.setDate(ReportService.formatDate(date)/1000);
        newOrder.setClientId(clientId);
        newOrder.setProductId(productId);
        orderService.insert(newOrder);
    }


}
