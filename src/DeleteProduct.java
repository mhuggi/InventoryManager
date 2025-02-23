import java.util.Scanner;

public class DeleteProduct {
    private final InventoryManager inventoryManager;

    public DeleteProduct(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID to Delete: ");
        int id = scanner.nextInt();
        inventoryManager.removeProduct(id);
        System.out.println("Product deleted if it existed.");
    }
}
