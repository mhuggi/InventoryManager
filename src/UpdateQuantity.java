import java.util.Scanner;

public class UpdateQuantity {
    private final InventoryManager inventoryManager;

    public UpdateQuantity(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID to Update: ");
        int id = scanner.nextInt();
        Product product = inventoryManager.findProductById(id);
        if (product != null) {
            System.out.print("Enter New Quantity: ");
            int newQuantity = scanner.nextInt();
            product.setQuantity(newQuantity);
            System.out.println("Product quantity updated.");
        } else {
            System.out.println("Product not found.");
        }
    }
}
