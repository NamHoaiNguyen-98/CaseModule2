package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import model.Account;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class AccountManager implements Serializable {
    private List<Account> accountList;
    private final Scanner scanner;

    //biên static currentUser
    private static AccountManager accountManager;
    private final String regex = "^\\w+$";
    String path = "D:\\CaseModule2\\src\\file\\Account.txt";

    private AccountManager(Scanner scanner) {
        this.accountList = ReadAndWriteFile.readFromFile(path);
        this.scanner = scanner;

    }

    public static AccountManager getInstance(Scanner scanner) {
        if (accountManager == null) {
            accountManager = new AccountManager(scanner);
        }
        return accountManager;
    }

    public void register() {
        while (true) {
            System.out.println("input Username: ");
            String username = Input.inputString(regex);
            if (!checkRegister(username)) {
                System.out.println("input Password: ");
                String password = Input.inputString(regex);
                Account account = new Account(username, password);
                accountList.add(account);
                System.out.println("You have registered successfully");
                ReadAndWriteFile.writeToFile(accountList, path);
                break;
            } else {
                System.out.println("This account has already existed ");
            }
        }
    }

    public boolean login() {
        int count = 0;
        while (count < 3) {
            System.out.println("input Username: ");
            String username = Input.inputString(regex);
            System.out.println("input Password: ");
            String password = Input.inputString(regex);
            for (Account account : accountList) {
                if (username != null && password != null) {
                    if (username.equals(account.getUsername()) && password.equals(account.getPassword())) {
                        account.setLogin(true);
                        System.out.println("Login success!");
                        return true;

                    }
                }
            }
            count++;
            System.out.println("incorrect account");

        }
        System.out.println("You have entered wrong more than 3 times");
        return false;
    }

    public boolean checkLogin() {
        for (Account account : accountList) {
            if (account.getUsername().equals("Admin") && account.isLogin()) {
                return true;
            }
        }
        return false;
    }


    public boolean checkRegister(String username) {
        boolean flag = false;
        for (Account account : accountList) {
            if (username.equals(account.getUsername())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void display() {
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    public String getUsername() {
        for (Account account : accountList) {
            if (account.isLogin()) {
                return account.getUsername();
            }
        }
        return "";
    }
}
