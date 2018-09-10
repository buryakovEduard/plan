package com.example.planb;

public class ProductType {
    private int id;
    private String nameProduct;
    private int price;
    private int count;

    public ProductType(){

    }

    public ProductType(int id, String nameProduct, int price, int count) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
