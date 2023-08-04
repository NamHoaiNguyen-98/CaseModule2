package menu;

import manager.generic.Input;
import manager.impl.CategoryManager;
import manager.impl.ProductManager;

import java.util.Scanner;

public class MenuProduct {
    public void menu(ProductManager productManager) {
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Add product");
            System.out.println("2. Update product");
            System.out.println("3. Delete product");
            System.out.println("4. Display all product");
            System.out.println("5. Display all product by status");
            System.out.println("6. Display all product by category");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    productManager.create();
                    break;
                case 2:
                    productManager.update();
                    break;
                case 3:
                    productManager.deleteById();
                    break;
                case 4:
                    productManager.display();
                    break;
                case 5:
                    productManager.displayByStatus();
                    break;
                case 6:
                    productManager.displayByCategory();
                    break;
            }
        } while (choice != 0);
    }

}
