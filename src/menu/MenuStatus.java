package menu;


import manager.generic.Input;
import manager.impl.StatusManager;

import java.util.Scanner;

public class MenuStatus {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        StatusManager statusManager = StatusManager.getInstance(scanner);
        int choice;
        do {
            System.out.println("Menu---------------------------------------------------------------");
            System.out.println("1. Add status");
            System.out.println("2. Update status");
            System.out.println("3. Display all status");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    statusManager.create();
                    break;
                case 2:
                    statusManager.update();
                    break;
                case 3:
                    statusManager.display();
                    break;
            }
        } while (choice != 0);
    }
}

