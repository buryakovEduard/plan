package com.example.planb;

public class Client {
    private long id;
    private String name;
    private long purchases = 0;

    public long getPurchases() {
        return purchases;
    }

    public void setPurchases(long purchases) {
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Client(){

    }
    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
