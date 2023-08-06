package menu;

import manager.generic.Input;
import manager.impl.ProductManager;

public class MenuAdmin {
    public void menu(ProductManager productManager) {
        MenuCategory menuCategory = new MenuCategory();
        MenuStatus menuStatus = new MenuStatus();
        MenuProduct menuProduct = new MenuProduct();
        int choice;
        do {
            System.out.println("Menu-------------------------------------------");
            System.out.println("1. Menu product");
            System.out.println("2. Menu category");
            System.out.println("3. Menu status");
            System.out.println("0. Log out");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    menuProduct.menu(productManager);
                    break;
                case 2:
                    menuCategory.menu();
                    break;
                case 3:
                    menuStatus.menu();
                    break;
            }
        } while (choice != 0);

    }
}
