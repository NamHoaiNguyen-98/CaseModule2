package model;

import manager.impl.CartManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class User implements Serializable {
    private static final long serialUID = 12345678;
    int id;
    Account account;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String address;
    private Cart cart;
    private boolean isLogin;

    public User() {
    }




    public User(int id, Account account, String name, String gender, int age, String phone, String address, Cart cart) {
//        this.account = account;
        this.id = id;
        this.account = account;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.cart = cart;
    }



    public Account getAccount() {
        return account;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return
                "Name: "  + name  +
                "\t Gender: " + gender  +
                "\t Age: " + age +
                "\t Phone: " + phone  +"\n"+
                "Address: " + address;
    }
}
