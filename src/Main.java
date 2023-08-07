import manager.generic.Input;
import manager.impl.AccountManager;
import manager.impl.ProductManager;
import menu.MenuAdmin;
import menu.MenuUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = ProductManager.getInstance(scanner);
        AccountManager accountManager = AccountManager.getInstance(scanner);
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuUser menuUser = new MenuUser();
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    if (accountManager.login()) {
                        if (accountManager.checkLogin()) {
                            menuAdmin.menu(productManager);
                        }
                        else {
                            menuUser.menu(productManager);
                        }
                    } break;
                case 2:
                    accountManager.register();
                    break;
                case 3:
                    accountManager.display();
                    break;
            }
        } while (choice != 0);

    }

}
