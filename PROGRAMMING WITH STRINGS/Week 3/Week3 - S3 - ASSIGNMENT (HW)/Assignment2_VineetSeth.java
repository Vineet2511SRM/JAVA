/**
 * Assignment 2: Online Shopping Cart System
 * Author: Vineet Seth
 * Description: A menu-driven shopping cart system demonstrating object
 * relationships and method interaction between Product and ShoppingCart classes.
 */

import java.util.Scanner;

/**
 * Represents a product available in the store.
 */
class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    // Static variables
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

    // ---------------- Getters ----------------
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Reduce stock
    public void reduceStock(int qty) { stockQuantity -= qty; }

    // Increase stock
    public void increaseStock(int qty) { stockQuantity += qty; }

    // ---------------- Static methods ----------------

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
     * Returns products by category.
     * @param products array of products
     * @param category category name
     */
    public static void getProductsByCategory(Product[] products, String category) {
        System.out.println("\nProducts in category: " + category);
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p);
            }
        }
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
        if (product.getStockQuantity() < quantity) {
            System.out.println("Not enough stock for " + product.getProductName());
            return;
        }
        products[itemCount] = product;
        quantities[itemCount] = quantity;
        product.reduceStock(quantity);
        itemCount++;
        calculateTotal();
        System.out.println(quantity + " x " + product.getProductName() + " added to cart.");
    }

    /**
     * Removes a product by ID.
     */
    public void removeProduct(String productId) {
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
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    /**
     * Calculates total cost of cart.
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
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].getProductName() + " x " + quantities[i] +
                               " = ₹" + (products[i].getPrice() * quantities[i]));
        }
        System.out.println("Cart Total: ₹" + cartTotal);
    }

    /**
     * Checkout process.
     */
    public void checkout() {
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

        // Create sample products (10 items)
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

        // Create cart
        ShoppingCart cart = new ShoppingCart("CART001", "Vineet", 20);

        int choice;
        do {
            System.out.println("\n=== Online Shopping Menu ===");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Enter category (Electronics/Clothing/Books/Home/Sports): ");
                    String cat = sc.nextLine();
                    Product.getProductsByCategory(products, cat);
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    String pid = sc.nextLine();
                    Product prod = Product.findProductById(products, pid);
                    if (prod != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        sc.nextLine();
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
        } while (choice != 0);

        sc.close();
    }
}
