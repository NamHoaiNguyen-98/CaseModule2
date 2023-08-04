package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import model.Account;
import model.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Cart implements Serializable {

//    private int id;
//    private Product product;
//    Account account;

    private final Scanner scanner;
    private final List<Product> cartList;
    private static Cart cart;
    private Cart(Scanner scanner) {
        this.scanner = scanner;
        cartList = ReadAndWriteFile.readFromFile("D:\\CaseModule2\\src\\file\\account\\"
                +AccountManager.getInstance(scanner).getUsername()+".txt");
    }
    public static Cart getInstance(Scanner scanner) {

        if (cart == null) {
            cart = new Cart(scanner);
        }
        return cart;
    }
    public void getCartList() {
        ProductManager.getInstance(scanner).display();
        System.out.println("Input id: ");
        int id = Input.inputInt();
        Product product = ProductManager.getInstance(scanner).findById(id);
        System.out.println("Input quantity");
        int quantity = Input.inputInt();
        product.setQuantity(quantity);
        cartList.add(product);
        ReadAndWriteFile.writeToFile(cartList,"D:\\CaseModule2\\src\\file\\account\\"
                +AccountManager.getInstance(scanner).getUsername()+".txt");
        System.out.println("Buy success");
    }
    public void displayCart() {
        for (Product product : cartList) {
            System.out.println(product);
        }
    }
}
