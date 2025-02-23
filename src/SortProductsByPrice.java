import java.util.*;

public class SortProductsByPrice {
    private final InventoryManager inventoryManager;

    public SortProductsByPrice(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        List<Product> products = new ArrayList<>(inventoryManager.getInventory());
        if (products.isEmpty()) {
            System.out.println("No products in inventory to sort.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sort by (1) Ascending or (2) Descending price? ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            products.sort(Comparator.comparingDouble(Product::getPrice));
        } else if (choice == 2) {
            products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        System.out.println("Products Sorted by Price:");
        for (Product product : products) {
            System.out.println(product.display());
        }
    }
}
