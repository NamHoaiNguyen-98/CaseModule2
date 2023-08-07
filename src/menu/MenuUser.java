package menu;

import manager.generic.Input;
import manager.impl.CartManager;
import manager.impl.ProductManager;
import manager.impl.UserManager;
import model.Cart;

import java.util.Scanner;

public class MenuUser {

    public void menu(ProductManager productManager) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = UserManager.getInstance(scanner);
        Cart cart = new Cart();
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Display all product");
            System.out.println("2. Display all product by status");
            System.out.println("3. Display all product by category");
            System.out.println("4. Search product by name");
            System.out.println("5. Search product by configuration");
            System.out.println("6. Search product by price");
            System.out.println("7. Search product by color");
            System.out.println("8. Display product sort by price");
            System.out.println("9. Buy product by ID");
            System.out.println("10. Display your Cart");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.displayByStatus();
                    break;
                case 3:
                    productManager.displayByCategory();
                    break;
                case 4:
                    productManager.searchByName();
                    break;
                case 5:
                    productManager.searchByConfiguration();
                    break;
                case 6:
                    productManager.searchByPrice();
                    break;
                case 7:
                    productManager.searchByColor();
                    break;
                case 8:
                    productManager.displaySortByPrice();
                    break;
                case 9:
                    userManager.create(cart);
                    break;
                case 10:
                    userManager.display();
                    break;
                case 11:
                    productManager.displaySortByID();
                    break;
            }
        } while (choice != 0);
    }
}
