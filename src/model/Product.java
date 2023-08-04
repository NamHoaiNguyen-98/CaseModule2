package model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private Status status;
    private String name;
    private Configuration configuration;
    private String color;
    private int quantity;
    private double price;
    private Category category;

    public Product() {
    }

    public Product(int id, Status status, String name, Configuration configuration, String color, int quantity, double price, Category category) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.configuration = configuration;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-12s%-23s%-29s%-10s%-15s%-32s%-22s%-13s%-10d%-15.0f%-10s",id,status.getName(),name,configuration.getCpu(),configuration.getRam(),configuration.getHardDrive(),configuration.getCardVga(),configuration.getScreen(),color,quantity,price,category.getName());
    }
}
