import java.util.Scanner;

public class AddProduct {
    private final InventoryManager inventoryManager;

    public AddProduct(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        inventoryManager.addProduct(new Product(id, name, quantity, price));
        System.out.println("Product added successfully.");
    }
}
