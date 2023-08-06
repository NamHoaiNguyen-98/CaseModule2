package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import model.*;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class UserManager implements Serializable {
    private final Scanner scanner;
    private final List<User> userList;
    private static UserManager userManager;
    String path = "D:\\CaseModule2\\src\\file\\User.txt";
    String pathProduct = "D:\\CaseModule2\\src\\file\\Product";
    String regex = "^.+$";

    private UserManager(Scanner scanner) {
        this.scanner = scanner;
        userList = ReadAndWriteFile.readFromFile(path);
    }

    public static UserManager getInstance(Scanner scanner) {
        if (userManager == null) {
            userManager = new UserManager(scanner);
        }
        return userManager;
    }

    public User getUser(Cart cart) {
        Product product= CartManager.getInstance(scanner).getCart(cart);
        System.out.println("You want buy this product ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Enter choice: ");
        int choice = Input.inputInt();
        if (choice == 1) {
            product.decreaseQuantity(cart.getQuantity());
            ProductManager.getInstance(scanner).getProductList();
            System.out.println("Please enter your information");
            Account account = AccountManager.getInstance(scanner).getAccount();
            int id = getIdUp();
            System.out.println("Input name: ");
            String name = Input.inputString(regex);
            System.out.println("Input Gender");
            String gender = Input.inputString(regex);
            System.out.println("Input Age: ");
            int age = Input.inputInt();
            System.out.println("Input Phone: ");
            String phone = Input.inputString("0[0-9]{9}");
            System.out.println("Input Address: ");
            String address = Input.inputString(regex);
            System.out.println("Buy product success!");
            return new User(id,account, name, gender, age, phone, address, cart);
        } else if (choice == 2) {
            cart.clearProduct();
            System.out.println("Thanks, You can choose another product");
            return null;
        } return null;

    }

    //    @Override
    public void create(Cart cart) {
        User user = getUser(cart);
        if (user != null) {
            userList.add(user);
            ReadAndWriteFile.writeToFile(userList, path);
        }
    }

    //    @Override
    public void update() {

    }

    //    @Override
    public void display() {
        for (User user : userList) {
            if (user !=null) {
            if (user.getAccount().getUsername().equals(AccountManager.getInstance(scanner).getAccount().getUsername())) {
                System.out.println(user);
                for (Product product : user.getCart().getProductList()) {
                    System.out.println("---------------------");
                    System.out.println("Your order information :");
                    System.out.println("Status: " + product.getStatus().getName());
                    System.out.println("Name : " + product.getName());
                    System.out.println("Quantity : " + user.getCart().getQuantity());
                    System.out.println("Price : " + product.getPrice());
                    System.out.println("Total Price: " + user.getCart().getTotalPrice());
                    System.out.println("-----------------------------------------------------------------------------------------------");

                }
            }
        } else {
                System.out.println("Invalid information");
            }
        }

    }
    public void displayAllCart() {
        for (User user : userList) {
            if (user !=null) {
                System.out.println(user);
                    for (Product product : user.getCart().getProductList()) {
                        System.out.println("Status: " + product.getStatus().getName());
                        System.out.println("Name : " + product.getName());
                        System.out.println("Quantity : " + user.getCart().getQuantity());
                        System.out.println("Price : " + product.getPrice());
                        System.out.println("Total Price: " + user.getCart().getTotalPrice());
                        System.out.println("---------------------------------------------------------------------------------------------");

                    }
                }
            }

    }
    //    @Override
    public User findById() {
        return null;
    }

    private int getIdUp() {
        int maxId = 0;
        for (User user : userList) {
            if (user.getId() > maxId) {
                maxId = user.getId();
            }
        }
        return maxId + 1;

    }
}
