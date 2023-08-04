package manager.inteface;

import model.Category;
import model.Configuration;
import model.Product;
import model.Status;

public interface IProduct extends Crud<Product> {
    void deleteById();
    void displaySortByPrice();
    void displayMaxPrice();

    void displayMinPrice();

    void searchByName();

    void searchByPrice();
    void searchByColor();

    void displayByStatus();
    void displayByCategory();
}
