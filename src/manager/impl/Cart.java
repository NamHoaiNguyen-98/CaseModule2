package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import model.Account;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class Cart {

    private int id;
    private Product product;
    Account account;











//    private final Scanner scanner = new Scanner(System.in);
//    private final List<Product> cartList;
//    private static Cart cart;
//    String path = "D:\\CaseModule2\\src\\file\\"+AccountManager.getInstance(scanner).getUsername();
//    private Cart() {
//        cartList = ReadAndWriteFile.readFromFile(path);
//    }
//    public static Cart getInstance() {
//
//        if (cart == null) {
//            cart = new Cart();
//        }
//        return cart;
//    }
//    public void getCartList() {
//        ProductManager.getInstance(scanner).display();
//        System.out.println("Input id: ");
//        int id = Input.inputInt();
//        Product product = ProductManager.getInstance(scanner).findById(id);
//        cartList.add(product);
//        ReadAndWriteFile.writeToFile(cartList,path);
//        System.out.println("Buy success");
//    }
//    public void displayCart() {
//        for (Product product : cartList) {
//            System.out.println(product);
//        }
//    }
}
