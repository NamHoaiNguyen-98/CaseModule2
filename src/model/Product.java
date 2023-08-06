package model;

import manager.impl.ProductManager;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private Status status;
    private String name;
    private String cpu;
    private String ram;
    private String hardDrive;
    private String cardVga;
    private String screen;
    private String color;
    private int quantity;
    private double price;
    private Category category;

    public Product() {
    }

    public Product(int id, Status status, String name, String cpu,
                   String ram, String hardDrive, String cardVga, String screen,
                   String color, int quantity, double price, Category category) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.cardVga = cardVga;
        this.screen = screen;
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

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getCardVga() {
        return cardVga;
    }

    public void setCardVga(String cardVga) {
        this.cardVga = cardVga;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
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

    public void decreaseQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Sorry, this product is out of stock");
        }
    }

    @Override
    public String toString() {
        return String.format("%-3d%-12s%-25s%-25s%-7s%-12s%-25s%-22s%-10s%-12d%-13.0f%-10s", id, status.getName(), name, cpu, ram, hardDrive, cardVga, screen, color, quantity, price, category.getName());
    }
}
