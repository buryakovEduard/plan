package com.example.planb;


public class Order {
    private long id;
    private long count;
    private long date;
    private String product;
    private String client;
    private long productId;
    private long clientId;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Order(){

    }


    public Order(long id, long count, long date, long productId, long clientId) {
        this.id = id;
        this.count = count;
        this.date = date;
        this.productId = productId;
        this.clientId = clientId;
    }
}
