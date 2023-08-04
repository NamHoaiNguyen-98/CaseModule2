package manager.generic;

import java.util.Scanner;

public class Input {
private static final Scanner scanner = new Scanner(System.in);
    public static String inputString(String regex) {
        for (int i = 1; i <= 3; i++) {
            String input = scanner.nextLine();
            if (input.matches(regex) && !input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Invalid input, please re-enter");
            }
        }
        System.out.println("You have entered wrong more than 3 times");
        return null;
    }


    public static Integer inputInt() {
        for (int i = 1; i <= 3; i++) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please re-enter");
            }

        }System.out.println("You have entered wrong more than 3 times");
        return 0;
    }


    public static Double inputDouble() {
        for (int i = 1; i <= 3; i++) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please re-enter");
            }

        } System.out.println("You have entered wrong more than 3 times");
        return 0.0;
    }

}
