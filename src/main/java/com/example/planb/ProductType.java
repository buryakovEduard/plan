package com.example.planb;

public class ProductType {
    private long id;
    private String nameProduct;
    private int price;
    private long count;

    public ProductType(){

    }

    public ProductType(long id, String nameProduct, int price, long count) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
