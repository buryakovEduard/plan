package com.example.planb;

import com.example.planb.Services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//////////////
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class GreetingController {


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return " ";
    }

    @GetMapping
    public String main(){
//        Imitation.newClient("Misha");
//        Imitation.newProduct(90,"cola");
//        Imitation.productToStorage(2, 20);
            Imitation.newOrder(50, "2018-07-14", 1, 1);
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
    };

}