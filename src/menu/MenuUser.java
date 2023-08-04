package menu;

import manager.generic.Input;
import manager.impl.Cart;
import manager.impl.ProductManager;

import java.util.Scanner;

public class MenuUser {
    Cart cart = Cart.getInstance();
    public void menu(ProductManager productManager) {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Display all product");
            System.out.println("2. Display all product by status");
            System.out.println("3. Display all product by category");
            System.out.println("4. Search product by name");
            System.out.println("5. Search product by price");
            System.out.println("6. Search product by color");
            System.out.println("7. Display all product price min");
            System.out.println("8. Display all product price max");
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
                    productManager.searchByPrice();
                    break;
                case 6:
                    productManager.searchByColor();
                    break;
                case 7:
                    productManager.displayMinPrice();
                    break;
                case 8:
                    productManager.displayMaxPrice();
                    break;
                case 9:
                    cart.getCartList();
                    break;
                case 10:
                    cart.displayCart();
                    break;

            }
        } while (choice != 0);
    }
}
