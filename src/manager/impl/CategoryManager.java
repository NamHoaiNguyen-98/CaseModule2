package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import manager.inteface.ICategory;
import model.Category;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class CategoryManager implements ICategory, Serializable {
    private final List<Category> categoryList;
    private final Scanner scanner;
    private static CategoryManager categoryManager;
    private final String path = "D:\\CaseModule2\\src\\file\\Category";
    private final String regex = "^[a-zA-Z0-9\\s]+$";

    private CategoryManager(Scanner scanner) {
        this.scanner = scanner;
        categoryList = ReadAndWriteFile.readFromFile(path);
    }

    public static CategoryManager getInstance(Scanner scanner) {
        if (categoryManager == null) {
            categoryManager = new CategoryManager(scanner);
        }
        return categoryManager;
    }

    public Category getCategory() {
        int id = getIdUp();
        System.out.println("Input name: ");
        String name = Input.inputString(regex);
        return new Category(id, name);
    }

    @Override
    public void create() {
        Category category = getCategory();
        if (category.getName() != null) {
            categoryList.add(category);
            ReadAndWriteFile.writeToFile(categoryList, path);
        } else {
            System.out.println("Add failed");
        }
    }

    @Override
    public void update() {
        Category category = findById();
        if (category != null) {
            System.out.println("input newName");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                category.setName(name);
            }
            System.out.println("Update success!");
        } else {
            System.out.println("Id does not exist");
        }
        ReadAndWriteFile.writeToFile(categoryList, path);
    }

    @Override
    public void display() {
        if (!categoryList.isEmpty()) {
            for (Category category : categoryList) {
                System.out.println(category);
            }
        } else {
            System.out.println("Category does not exits");
        }
    }

    @Override
    public Category findById() {
        System.out.println("Input id: ");
        int id = Input.inputInt();
        for (Category category : categoryList) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    private int getIdUp() {
        int maxId = 0;
        for (Category category : categoryList) {
            if (category.getId() > maxId) {
                maxId = category.getId();
            }
        }
        return maxId + 1;

    }


}
