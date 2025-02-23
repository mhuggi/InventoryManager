import java.util.*;

public class SortProductsByName {
    private final InventoryManager inventoryManager;

    public SortProductsByName(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        List<Product> products = new ArrayList<>(inventoryManager.getInventory());
        if (products.isEmpty()) {
            System.out.println("No products in inventory to sort.");
            return;
        }
        products.sort(Comparator.comparing(Product::getName));
        System.out.println("Products Sorted by Name:");
        for (Product product : products) {
            System.out.println(product.display());
        }
    }
}
