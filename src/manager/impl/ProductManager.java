package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import manager.inteface.IProduct;

import model.Category;
import model.Configuration;
import model.Product;
import model.Status;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements IProduct, Serializable {

    private final Scanner scanner;
    private final List<Product> productList;
    private final String path = "D:\\CaseModule2\\src\\file\\Product";
    private static ProductManager productManager;
    private final String regex = "^[a-zA-Z0-9\\s]+$";

    private ProductManager(Scanner scanner) {
        this.scanner = scanner;
        productList = ReadAndWriteFile.readFromFile(path);
    }

    public static ProductManager getInstance(Scanner scanner) {
        if (productManager == null) {
            productManager = new ProductManager(scanner);
        }
        return productManager;
    }

    private Product getProduct() {
        int id = getIdUp();
        StatusManager.getInstance(scanner).display();
        Status status = StatusManager.getInstance(scanner).findById();
        System.out.println("Input name: ");
        String name = Input.inputString(regex);
        Configuration configuration = ConfigurationManager.getInstance(scanner).getConfiguration();
        System.out.println("Input color: ");
        String color = Input.inputString(regex);
        System.out.println("Input quantity: ");
        int quantity = Input.inputInt();
        System.out.println("Input price: ");
        double price = Input.inputDouble();
        CategoryManager.getInstance(scanner).display();
        System.out.println("Input category: ");
        Category category = CategoryManager.getInstance(scanner).findById();
        return new Product(id, status, name, configuration, color, quantity, price, category);
    }

    @Override
    public void create() {
        Product product = getProduct();
        if (product.getName() != null || product.getColor() != null
                || product.getQuantity() != 0
                || product.getPrice() != 0.0) {
            productList.add(product);
            System.out.println("Add success !");

        } else {
            System.out.println("Add product failed");
        }
        ReadAndWriteFile.writeToFile(productList, path);
    }

    @Override
    public void update() {
        System.out.println("Input id: ");
        int id = Input.inputInt();
        Product product = findById(id);
        if (product != null) {
            StatusManager.getInstance(scanner).display();
            System.out.println("Input New status: ");
            Status status = StatusManager.getInstance(scanner).findById();
            product.setStatus(status);
            System.out.println("Input New name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                product.setName(name);
            }
            ConfigurationManager.getInstance(scanner).update(id);
            System.out.println("Input color: ");
            String color = scanner.nextLine();
            if (!color.isEmpty()) {
                product.setColor(color);
            }
            System.out.println("Input quantity: ");
            String quantity = scanner.nextLine();
            if (!quantity.isEmpty()) {
                product.setQuantity(Integer.parseInt(quantity));
            }
            System.out.println("Input price: ");
            String price = scanner.nextLine();
            if (!price.isEmpty()) {
                product.setPrice(Double.parseDouble(price));
            }
            CategoryManager.getInstance(scanner).display();
            System.out.println("Input New category: ");
            Category category = CategoryManager.getInstance(scanner).findById();
            product.setCategory(category);
            System.out.println("Update success !");
        } else {
            System.out.println("Id does not exist");
        }
        ReadAndWriteFile.writeToFile(productList, path);

    }

    @Override
    public void display() {
        if (!productList.isEmpty()) {
            System.out.printf("%-5s%-13s%-25s%-25s%-12s%-13s%-32s%-22s%-13s%-12s%-15s%-20s"
                    ,"ID","Status","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
            System.out.println();
            for (Product product : productList) {
                System.out.println(product);
            }
        } else {
            System.out.println("Product does not exits ");
        }
    }



    //@Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    @Override
    public void deleteById() {
        if (!productList.isEmpty()) {
            Product product = findById();
            if (product != null) {
                productList.remove(product);
                System.out.println("Delete success ");
            } else {
                System.out.println("Id does not exist");
            }
        } else {
            System.out.println("Product does not exits ");
        }
        ReadAndWriteFile.writeToFile(productList, path);

    }

    @Override
    public void displaySortByPrice() {
        SortByPrice sort = new SortByPrice();
        productList.sort(sort);
        System.out.printf("%-5s%-13s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
                ,"ID","Status","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
        System.out.println(productList);
    }

    @Override
    public void displayMaxPrice() {
        if (!productList.isEmpty()) {
            System.out.println("Product is Max Price: ");
            displaySortByPrice();
            double max = productList.get(productList.size() - 1).getPrice();
            System.out.println();
            for (Product product : productList) {
                if (max == product.getPrice()) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("List Product is empty");
        }
    }

    @Override
    public void displayMinPrice() {
        if (!productList.isEmpty()) {
            System.out.println("Product is Min Price: ");
            displaySortByPrice();
            double min = productList.get(0).getPrice();
            for (Product product : productList) {
                if (min == product.getPrice()) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println("List Product is empty");
        }

    }

    @Override
    public void searchByName() {
        boolean flag = true;
        System.out.println("Input name you want search: ");
        String name = Input.inputString(regex);
        if (name != null) {
            System.out.printf("%-5s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
                    ,"ID","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
            System.out.println();
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(product);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Not exist product have name contains this word!");
            }
        }
    }

    @Override
    public void searchByPrice() {
        boolean flag = true;
        System.out.println("Input min price you want search: ");
        double min = Input.inputDouble();
        System.out.println("Input max price you want search: ");
        double max = Input.inputDouble();
        if (min > max) {
            System.out.println("Please input again!");
        } else {
//            System.out.printf("%-5s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
//                    ,"ID","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
//            System.out.println();
            for (Product product : productList) {
                if (product.getPrice() > min && product.getPrice() < max) {
                    System.out.println(product);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Not exist product have price between your input!");
            }
        }
    }

    @Override
    public void searchByColor() {
        boolean flag = true;
        System.out.println("Input color you want search");
        String color = Input.inputString(regex);
        if (color != null) {
            System.out.printf("%-5s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
                    ,"ID","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
            System.out.println();
            for (Product product : productList) {
                if (product.getColor().toLowerCase().contains(color.toLowerCase())) {
                    System.out.println(product);
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Not exist product have name contains this word!");
            }
        }
    }

    @Override
    public void displayByStatus() {
        boolean flag = true;
        StatusManager.getInstance(scanner).display();
        Status status1 = StatusManager.getInstance(scanner).findById();
        System.out.printf("%-5s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
                ,"ID","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
        System.out.println();
        for (Product product : productList) {
            if (product.getStatus().getId() == status1.getId()) {
                System.out.println(product);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("There is no product in the status you selected");
        }
    }

    @Override
    public void displayByCategory() {
        boolean flag = true;
        CategoryManager.getInstance(scanner).display();
        Category category1 = CategoryManager.getInstance(scanner).findById();
        System.out.printf("%-5s%-25s%-30s%-10s%-15s%-32s%-22s%-13s%-12s%-15s%-20s"
                ,"ID","Name","Cpu","Ram","HardDrive","CardVga","Screen","Color","Quantity","Price","Category");
        System.out.println();
        for (Product product : productList) {
            if (product.getCategory().getId() == category1.getId()) {
                System.out.println(product);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("There is no product in the category you selected");
        }

    }

    private int getIdUp() {
        int maxId = 0;
        for (Product product : productList) {
            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }
        return maxId + 1;

    }
    @Override
    public Product findById() {
        return null;
    }


}
