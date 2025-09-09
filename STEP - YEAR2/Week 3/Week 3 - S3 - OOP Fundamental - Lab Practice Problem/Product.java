import java.util.Scanner;

public class Product {
    // a. Private instance variables
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;

    // b. Static variables
    private static int totalProducts = 0;
    private static double totalInventoryValue = 0;
    private static int lowStockCount = 0;

    // Constructor
    public Product(String productId, String productName, double price, int quantity, String supplierName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.category = category;
        totalProducts++;
    }

    // c. Instance methods
    public void addStock(int qty) {
        quantity += qty;
        System.out.println(productName + ": Stock increased by " + qty + ". Current stock = " + quantity);
    }

    public void reduceStock(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(productName + ": Stock reduced by " + qty + ". Current stock = " + quantity);
        } else {
            System.out.println("Not enough stock for " + productName);
        }
    }

    public boolean isLowStock() {
        return quantity < 10;
    }

    // d. Other methods
    public double calculateProductValue() {
        return price * quantity;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Updated price of " + productName + " to " + newPrice);
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Price: " + price +
                ", Quantity: " + quantity + ", Supplier: " + supplierName + ", Category: " + category);
    }

    // e. Static methods
    public static double calculateTotalInventoryValue(Product[] products) {
        totalInventoryValue = 0;
        for (Product p : products) {
            totalInventoryValue += p.calculateProductValue();
        }
        return totalInventoryValue;
    }

    public static void findLowStockProducts(Product[] products) {
        lowStockCount = 0;
        System.out.println("\n--- Low Stock Products (qty < 10) ---");
        for (Product p : products) {
            if (p.isLowStock()) {
                lowStockCount++;
                p.displayProductInfo();
            }
        }
        if (lowStockCount == 0) {
            System.out.println("No low stock products.");
        }
    }

    public static void generateInventoryReport(Product[] products) {
        System.out.println("\n--- Inventory Report ---");
        for (Product p : products) {
            p.displayProductInfo();
            System.out.println("Value: " + p.calculateProductValue());
        }
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Inventory Value: " + calculateTotalInventoryValue(products));
    }

    // f. Search product
    public static Product searchProduct(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // g. Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // create array of products
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Product[] products = new Product[n];

        // take user input for products
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));
            System.out.print("Product ID: ");
            String id = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();
            System.out.print("Supplier: ");
            String supplier = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, price, qty, supplier, category);
        }

        // --- Demonstrate Instance Methods ---
        System.out.println("\n--- Demonstrating Instance Methods ---");
        products[0].addStock(5);   // add stock for first product
        products[1].reduceStock(2); // reduce stock for second product
        products[0].updatePrice(products[0].price + 50); // update price

        // --- Demonstrate Static Methods ---
        System.out.println("\n--- Demonstrating Static Methods ---");
        generateInventoryReport(products); // static report
        findLowStockProducts(products);    // static low stock check

        // search demo
        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();
        Product found = searchProduct(products, searchName);
        if (found != null) {
            System.out.println("Product found:");
            found.displayProductInfo();
        } else {
            System.out.println("Product not found.");
        }

        sc.close();

        // clear difference at end
        System.out.println("\n--- Static vs Instance Variables ---");
        System.out.println("Static -> totalProducts = " + totalProducts + " (shared by all objects)");
        System.out.println("Instance -> Each product has its own price, quantity, supplier, etc.");
    }
}
