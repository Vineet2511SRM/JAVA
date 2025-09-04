/**
 * Assignment 2: Online Shopping Cart System
 * Author: Vineet Seth
 * Description: A menu-driven shopping cart system demonstrating object
 * relationships, error handling, and method interaction between Product and ShoppingCart classes.
 */

import java.util.*;

/**
 * Represents a product available in the store.
 */
class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    private static int totalProducts = 0;
    private static String[] categories = {"Electronics", "Clothing", "Books", "Home", "Sports"};

    /**
     * Constructs a Product with given details.
     */
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    // ---------- Getters ----------
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    /**
     * Reduces stock by given quantity.
     */
    public void reduceStock(int qty) { stockQuantity -= qty; }

    /**
     * Increases stock by given quantity.
     */
    public void increaseStock(int qty) { stockQuantity += qty; }

    /**
     * Finds a product by its ID.
     * @param products array of products
     * @param productId the product ID to search
     * @return matching Product or null if not found
     */
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p.getProductId().equalsIgnoreCase(productId)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Displays products by category.
     * @param products array of products
     * @param category category name
     */
    public static void getProductsByCategory(Product[] products, String category) {
        System.out.println("\nProducts in category: " + category);
        boolean found = false;
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("No products found in this category.");
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | ₹" + price + " | Stock: " + stockQuantity;
    }
}

/**
 * Represents a shopping cart for a customer.
 */
class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;

    /**
     * Constructs a ShoppingCart with a fixed size.
     */
    public ShoppingCart(String cartId, String customerName, int maxSize) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[maxSize];
        this.quantities = new int[maxSize];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    /**
     * Adds a product to the cart.
     */
    public void addProduct(Product product, int quantity) {
        try {
            if (quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero.");
            if (quantity > product.getStockQuantity()) throw new IllegalArgumentException("Not enough stock for " + product.getProductName());
            if (itemCount >= products.length) throw new IllegalStateException("Cart is full. Cannot add more items.");

            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.reduceStock(quantity);
            itemCount++;
            calculateTotal();
            System.out.println(quantity + " x " + product.getProductName() + " added to cart.");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    /**
     * Removes a product from the cart by its ID.
     */
    public void removeProduct(String productId) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equalsIgnoreCase(productId)) {
                products[i].increaseStock(quantities[i]); // restore stock
                System.out.println(products[i].getProductName() + " removed from cart.");
                // shift items
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Product not found in cart.");
    }

    /**
     * Calculates the total cost of the cart.
     */
    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    /**
     * Displays the cart contents.
     */
    public void displayCart() {
        System.out.println("\n--- Cart Summary ---");
        System.out.println("Customer: " + customerName + " | Cart ID: " + cartId);
        if (itemCount == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(products[i].getProductName() + " x " + quantities[i] +
                                   " = Rs " + (products[i].getPrice() * quantities[i]));
            }
            System.out.println("Cart Total: Rs " + cartTotal);
        }
    }

    /**
     * Checkout process.
     */
    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }
        displayCart();
        System.out.println("Checkout complete! Thank you for shopping, " + customerName + "!");
        itemCount = 0;
        cartTotal = 0.0;
    }
}

/**
 * Main driver class for the Shopping Cart System.
 */
public class Assignment2_VineetSeth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample products
        Product[] products = {
            new Product("P101", "Laptop", 55000, "Electronics", 5),
            new Product("P102", "Headphones", 1500, "Electronics", 10),
            new Product("P103", "Smartphone", 30000, "Electronics", 8),
            new Product("P104", "T-Shirt", 500, "Clothing", 15),
            new Product("P105", "Jeans", 1200, "Clothing", 10),
            new Product("P106", "Novel", 400, "Books", 12),
            new Product("P107", "Cookbook", 600, "Books", 7),
            new Product("P108", "Mixer Grinder", 2500, "Home", 6),
            new Product("P109", "Football", 800, "Sports", 9),
            new Product("P110", "Cricket Bat", 1500, "Sports", 5)
        };

        ShoppingCart cart = new ShoppingCart("CART001", "Vineet", 20);

        int choice = -1;
        do {
            try {
                System.out.println("\n=== Online Shopping Menu ===");
                System.out.println("1. View All Products");
                System.out.println("2. View Products by Category");
                System.out.println("3. Add Product to Cart");
                System.out.println("4. Remove Product from Cart");
                System.out.println("5. View Cart");
                System.out.println("6. Checkout");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("\nAvailable Products:");
                        for (Product p : products) System.out.println(p);
                        break;
                    case 2:
                        System.out.print("Enter category: ");
                        String cat = sc.nextLine();
                        Product.getProductsByCategory(products, cat);
                        break;
                    case 3:
                        System.out.print("Enter Product ID: ");
                        String pid = sc.nextLine();
                        Product prod = Product.findProductById(products, pid);
                        if (prod != null) {
                            System.out.print("Enter quantity: ");
                            int qty = Integer.parseInt(sc.nextLine());
                            cart.addProduct(prod, qty);
                        } else {
                            System.out.println("Invalid Product ID.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Product ID to remove: ");
                        String remId = sc.nextLine();
                        cart.removeProduct(remId);
                        break;
                    case 5:
                        cart.displayCart();
                        break;
                    case 6:
                        cart.checkout();
                        break;
                    case 0:
                        System.out.println("Exiting... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);

        sc.close();
    }
}
