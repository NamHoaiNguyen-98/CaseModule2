package manager.impl;
import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import manager.inteface.IStatus;
import model.Status;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class StatusManager implements IStatus, Serializable {
    private final Scanner scanner;
    private final List<Status> statusList;
    private final String path = "D:\\CaseModule2\\src\\file\\Status";
    private final String regex = "^.+$";
    private static StatusManager statusManager;

    private StatusManager(Scanner scanner) {
        this.scanner = scanner;
        statusList = ReadAndWriteFile.readFromFile(path);
    }

    public static StatusManager getInstance(Scanner scanner) {
        if (statusManager == null) {
            statusManager = new StatusManager(scanner);
        }
        return statusManager;
    }

    public Status getStatus() {
        int id = getIdUp();
        System.out.println("Input name: ");
        String name = Input.inputString(regex);
        return new Status(id, name);
    }
    @Override
    public void create() {
        Status status = getStatus();
        if (status.getName() != null) {
            statusList.add(status);
            System.out.println("Add success");

        } else {
            System.out.println("Add failed");
        } ReadAndWriteFile.writeToFile(statusList, path);
    }

    @Override
    public void update() {
        Status status = findById();
        if (status != null) {
            System.out.println("input newName");
            String name = Input.inputString(regex);
            status.setName(name);
            System.out.println("Update success!");
        } else {
            System.out.println("Id does not exist");
        }
        ReadAndWriteFile.writeToFile(statusList,path);

    }

    @Override
    public void display() {
        if (!statusList.isEmpty()) {
            for (Status status : statusList) {
                System.out.println(status);
            }
        } else {
            System.out.println("Status does not exits in List");
        }

    }

   @Override
    public Status findById() {
       System.out.println("Input id: ");
       int id = Input.inputInt();
        for (Status status : statusList) {
            if (status.getId() == id) {
                return status;
            }
        }
        return null;
    }
    private int getIdUp() {
        int maxId = 0;
        for (Status status : statusList) {
            if (status.getId() > maxId) {
                maxId = status.getId();
            }
        }
        return maxId + 1;

    }
}
