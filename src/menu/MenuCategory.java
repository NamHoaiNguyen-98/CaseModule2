package menu;

import manager.generic.Input;
import manager.impl.CategoryManager;

import java.util.Scanner;
public class MenuCategory {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        CategoryManager categoryManager = CategoryManager.getInstance(scanner);
        int choice;
        do {
            System.out.println("Menu-------------------------------------------------");
            System.out.println("1. Add category");
            System.out.println("2. Update category");
            System.out.println("3. Display all category");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    categoryManager.create();
                    break;
                case 2:
                    categoryManager.update();
                    break;
                case 3:
                    categoryManager.display();
                    break;
            }
        } while (choice != 0);
    }

}
