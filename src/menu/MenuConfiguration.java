package menu;

import manager.generic.Input;
import manager.impl.ConfigurationManager;

import java.util.Scanner;

public class MenuConfiguration {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        ConfigurationManager configurationManager= ConfigurationManager.getInstance(scanner);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Add configuration");
            System.out.println("2. Update configuration");
            System.out.println("3. Display configuration");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    configurationManager.create();
                    break;
                case 2:
                    configurationManager.update();
                    break;
                case 3:
                    configurationManager.display();
                    break;
            }
        } while (choice != 0);
    }
}
