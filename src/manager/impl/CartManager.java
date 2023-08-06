package manager.impl;

import manager.generic.Input;
import manager.generic.ReadAndWriteFile;
import model.Cart;
import model.Product;


import java.io.Serializable;


import java.util.List;
import java.util.Scanner;

public class CartManager implements Serializable {
    private final Scanner scanner;
    private List<Cart> cartList;
    private static CartManager cartManager;
    String path = "D:\\CaseModule2\\src\\file\\Cart.txt";

    private CartManager(Scanner scanner) {
        this.scanner = scanner;
        cartList = ReadAndWriteFile.readFromFile(path);
    }

    public static CartManager getInstance(Scanner scanner) {
        if (cartManager == null) {
            cartManager = new CartManager(scanner);
        }
        return cartManager;
    }

    public Product getCart(Cart cart) {
        System.out.println("Input id product you want buy: ");
        int id = Input.inputInt();
        Product product = ProductManager.getInstance(scanner).findById(id);
        if (product != null) {
            System.out.println("Input quantity: ");
            int quantity = Input.inputInt();
            if (quantity <= product.getQuantity()) {
                double totalPrice = product.getPrice() * quantity;
                cart.getProductList().add(product);
                cart.setQuantity(quantity);
                cart.setTotalPrice(totalPrice);
            } else {
                System.out.println("Sorry, the product quantity is not enough");
            }
        } return product;
    }


//    public void create(Cart cart) {
//        if (cart != null) {
//            cartList.add(cart);
//            ReadAndWriteFile.writeToFile(cartList, path);
//            System.out.println("Product add to cart success");
//        } else {
//            System.out.println("Product add failed");
//        }
//    }


//    @Override
//    public void update() {
//
//    }

//    @Override
//    public void display() {
//        for (Cart cart : cartList) {
//            System.out.println("Date: " + cart.getDate());
//            for (Product product : cart.getProductList()) {
//                System.out.println("ID : " + product.getId());
//                System.out.println("Status: " + product.getStatus());
//                System.out.println("Name : " + product.getName());
//                System.out.println("Quantity : " + product.getQuantity());
//                System.out.println("Price : " + product.getPrice());
//                System.out.println("Total Price : " + cart.getTotalPrice());
//            }
//        }
//
//    }


    public Cart findById(int id) {
        for (Cart cart : cartList) {
            if (cart.getId() == id) {
                return cart;
            }
        }
        return null;
    }

}

