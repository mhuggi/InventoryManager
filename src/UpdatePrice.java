import java.util.Scanner;

public class UpdatePrice {
    private final InventoryManager inventoryManager;

    public UpdatePrice(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID to update price: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product = inventoryManager.findProductById(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        product.setPrice(newPrice);
        System.out.println("Price updated successfully.");
    }
}
