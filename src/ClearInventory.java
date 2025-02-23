import java.util.Scanner;

public class ClearInventory {
    private final InventoryManager inventoryManager;

    public ClearInventory(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to clear the inventory? (yes/no): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            inventoryManager.clearInventory();
            System.out.println("Inventory cleared.");
        } else {
            System.out.println("Operation cancelled.");
        }
    }
}
