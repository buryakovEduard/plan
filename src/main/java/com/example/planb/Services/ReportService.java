package com.example.planb.Services;

import com.example.planb.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
//реализованны методы для вывода отчетов
public class ReportService {
    //метод складывает общую сумму транзакций по имени
    public static List<Order> client (List<Order> list) {
        List<Order> newList = new ArrayList<>();

        for(Order j: list){
            Order temp = new Order(); //новый объект для отчёта
            temp.setClient(j.getClient());
            temp.setClientId(j.getClientId());
            for(Order o : list) {
                if(o.getClient().equals(j.getClient())) {
                    temp.setCount(temp.getCount()+o.getCount());
                }
            }
            newList.add(temp);
        }

        return newList;
    }
    //Переводит дату в миллисекудны (Собирался сделать форму которая задает интервал времени)
    public static long formatDate(String date){
        long f = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            f = formatter.parse(date).getTime(); // парсит дату и переводит миллисекунды
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return f;
    }
    //Возвращает List объектов за определенный интервал
    public static List<Order> getInterval(List<Order> list, String from, String to){
        List<Order> newlist = new ArrayList<>();
        long f = formatDate(from);
        long t = formatDate(to);
        for (Order i : list){ //возвращает новый List с объектами которые находятся в заданном промежутке времени
            if(i.getDate()* 1000 >= f && i.getDate() * 1000 <= t){
                newlist.add(i);
            } }
        newlist.sort(Comparator.comparing(Order::getDate));
        Collections.reverse(newlist);
        return newlist;
    }
    //топ 10
    public static List<Order> getTop(List<Order> list, String from, String to){
        List<Order> newlist = new ArrayList<>();
        newlist = ReportService.getInterval(list,from,to);
        newlist = ReportService.client(newlist);
        return newlist;
    }
}
