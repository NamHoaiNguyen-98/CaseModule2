package model;

import manager.impl.UserManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart implements Serializable {

    private int id;
    private double totalPrice;
    private int quantity;
    private List<Product> productList;
    private Scanner scanner;

    public Cart() {
        productList = new ArrayList<>();
    }

    public Cart(int id, double totalPrice, int quantity, List<Product> productList, Scanner scanner) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.productList = productList;
        this.scanner = scanner;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser(Cart cart) {
        return UserManager.getInstance(scanner).getUser(cart);
    }






    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void clearProduct() {
        productList.clear();
    }

    @Override
    public String toString() {
        return
                "date=" ;
    }
    //    private Cart(Scanner scanner) {
//        this.scanner = scanner;
//        cartList = ReadAndWriteFile.readFromFile("D:\\CaseModule2\\src\\file\\account\\"
//                +AccountManager.getInstance(scanner).getUsername()+".txt");
//    }
//    public static Cart getInstance(Scanner scanner) {
//
//        if (cart == null) {
//            cart = new Cart(scanner);
//        }
//        return cart;
//    }
//    public void getCartList() {
//        ProductManager.getInstance(scanner).display();
//        System.out.println("Input id: ");
//        int id = Input.inputInt();
//        Product product = ProductManager.getInstance(scanner).findById(id);
//        System.out.println("Input quantity");
//        int quantity = Input.inputInt();
//        product.setQuantity(quantity);
//        cartList.add(product);
//        ReadAndWriteFile.writeToFile(cartList,"D:\\CaseModule2\\src\\file\\account\\"
//                +AccountManager.getInstance(scanner).getUsername()+".txt");
//        System.out.println("Buy success");
//    }
//    public void displayCart() {
//        for (Product product : cartList) {
//            System.out.println(product);
//        }
//    }
}
