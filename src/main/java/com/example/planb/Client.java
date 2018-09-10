package com.example.planb;

public class Client {
    private int id;
    private String name;
    private int purchases = 0;

    public Client(){

    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
