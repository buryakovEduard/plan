package com.example.planb;

import com.example.planb.Services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping
    public String main(){
/*        Imitation.newClient("Misha");
        Imitation.newProduct(90,"cola", 20);
        Imitation.newOrder(50, "2018-09-09", 1, 1);*/
        return "main";
    }

    @GetMapping("/clients")
    public String getClients(Map<String, Object> model){
      ClientService service = new ClientService();
      List<Client> list = service.selectAllClients();
      model.put("clients", list);
        return "clients";
    }

    @GetMapping("/storage")
    public String getProducts(Map<String, Object> model){
        ProductService service = new ProductService();
        List<ProductType> list = service.selectAllProducts();
        model.put("products", list);
        return "products";
    }

    @GetMapping("/orders")
    public String getOrders (Map<String, Object> model){
        OrderService service = new OrderService();
        List<Order> list = service.selectAllOrders();
        List<Order> formatList = ReportService.getInterval(list, "2018-09-08", "2018-09-11");
        model.put("orders", formatList);
        return "orders";
    }

    @GetMapping("/top")
    public String getTop (Map<String, Object> model){
        OrderService service = new OrderService();
        List<Order> list = service.selectAllOrders();
        List<Order> formatList = ReportService.getTop(list, "2018-09-08", "2018-09-11");
        model.put("top", formatList);
        return "top";
    }

    @GetMapping("/reports")
    public String getR(Map<String, Object> model) {
        OrderService service = new OrderService();
        List<Order> list = service.selectAllOrders();
        return "reports";
    }

}