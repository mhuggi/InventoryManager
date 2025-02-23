import java.util.Scanner;

public class SearchProduct {
    private final InventoryManager inventoryManager;

    public SearchProduct(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID or Name to Search: ");
        String query = scanner.nextLine();
        for (Product product : inventoryManager.getInventory()) {
            if (String.valueOf(product.getId()).equals(query) || product.getName().equalsIgnoreCase(query)) {
                System.out.println("Product Found:");
                System.out.println(product.display());
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
